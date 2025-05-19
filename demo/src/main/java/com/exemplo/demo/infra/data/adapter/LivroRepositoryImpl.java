package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.exceptions.LivroNotFoundException;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.data.config.EntityMapper;
import com.exemplo.demo.infra.data.config.EntityMapperInterface;
import com.exemplo.demo.infra.data.dto.LivroAvaliacaoView;
import com.exemplo.demo.infra.data.dto.LivroLeituraView;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


//tirar notação
@Repository
public class LivroRepositoryImpl implements LivroRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private EntityMapperInterface entityMapper;

    public LivroRepositoryImpl(EntityMapperInterface entityMapper){
        this.entityMapper = entityMapper;
    }

    public LivroRepositoryImpl(){

    }

    @Transactional
    public void salvar(Livro livro) {
        LivroJPA livroJPA = entityMapper.mapLivro(livro);
        entityManager.persist(livroJPA); // Insere novo
        // ou: entityManager.merge(aluno); // Insere ou atualiza (mais seguro)
    }


    public List<LivroAvaliacaoView> buscarAvaliacoes() {
        List<LivroAvaliacaoView> livrosComNota = entityManager.createQuery("""
                    SELECT new com.exemplo.demo.infra.data.dto.LivroAvaliacaoView(
                        a.livroJPA.nome,
                        a.livroJPA.autor,
                        a.nota
                    )
                    FROM AvaliacaoJPA a
                """, LivroAvaliacaoView.class).getResultList();

        // Exibir resultados
        for (LivroAvaliacaoView l : livrosComNota) {
            System.out.println("Livro: " + l.getNome() +
                    ", Autor: " + l.getAutor() +
                    ", Nota: " + l.getNota());
        }

        return livrosComNota;
    }


//    metodo pra achar livro


    @Transactional
    public void deletar(Livro livro){
        String nomeAutor = livro.getNomeAutor();
        String nome = livro.getNome();

        String sql = "SELECT * FROM tb_livro WHERE  nome = :nomeLivro and autor = :nomeAutor ;";
        LivroJPA livroJPA = findLivro(nome,nomeAutor,sql);
        System.out.println(livroJPA.getAutor());
        System.out.println(livroJPA.getLivro_id());
//        LeituraJPA leituraJPA = findLeitura(livroJPA.getLivro_id());
//        deletarSql(leituraJPA.getLeitura_id());

        deletarLivroPorId(livroJPA.getLivro_id());
//        deletarPorLivroId(livroJPA.getLivro_id());
    }

    @Transactional
    public void deletarLivroPorId(UUID livroId) {
        LivroJPA livro = entityManager.find(LivroJPA.class, livroId);
        if (livro != null) {
            entityManager.remove(livro);
        }
        else{
            throw new LivroNotFoundException();
        }
    }

    @Transactional
    public LivroJPA findLivro(String nomeLivro, String nomeAutor, String sql){
        LivroJPA livroJPA = (LivroJPA) entityManager.createNativeQuery(sql, LivroJPA.class)
                .setParameter("nomeLivro", nomeLivro)
                .setParameter("nomeAutor", nomeAutor)
                .getResultStream()
                .findFirst()
                .orElse(null);
        if(livroJPA == null){
            throw new LivroNotFoundException();
        }
        else{
            return livroJPA;
        }

    }

}
