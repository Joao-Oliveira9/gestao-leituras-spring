package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.Avaliacao;

import com.exemplo.demo.exceptions.LivroNotFoundException;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.Port.NotaRepository;
import com.exemplo.demo.infra.data.config.EntityMapperInterface;
import com.exemplo.demo.infra.data.jpa.AvaliacaoJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class NotaRepositoryImpl implements NotaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private EntityMapperInterface entityMapper;

    LivroRepository livroRepository;

    public NotaRepositoryImpl(EntityMapperInterface entityMapper, LivroRepository livroRepository){
        this.entityMapper = entityMapper;
    }


    @Transactional
    public void salvar(Avaliacao avaliacao) {
        String sql = "SELECT * FROM tb_livro WHERE  nome = :nomeLivro and autor = :nomeAutor ;";

        //pegar nomeAutor e nomeLivro, faz sentido ter esses campos em avaliacao?

        String nomeAutor = avaliacao.getNomeAutor();
        String nomeLivro = avaliacao.getNomeLivro();

        System.out.println(nomeAutor);
        System.out.println(nomeLivro);

        LivroJPA livroJPA = findLivro(nomeLivro, nomeAutor, sql);

        System.out.println(livroJPA.getNome());
        System.out.println(avaliacao.getStatusAval());

        AvaliacaoJPA avaliacaoJPA = entityMapper.mapAvaliacao(avaliacao,livroJPA);

        System.out.println(avaliacaoJPA.getNota());
        salvarSql(avaliacaoJPA);
//        System.out.println(livroJPA.getLivro_id());
        //mapear avaliacao em avaliacaoJPA
        //persist -> salvar
    }

    //funcao que busca livro baseado no autor e no nomeLivro
    public LivroJPA findLivro(String nomeLivro,String nomeAutor,String sql){
        LivroJPA livroJPA = (LivroJPA) entityManager.createNativeQuery(sql, LivroJPA.class)
                .setParameter("nomeLivro", nomeLivro)
                .setParameter("nomeAutor", nomeAutor)
                .getResultStream()
                .findFirst()
                .orElse(null);

        if(livroJPA == null){
            throw new LivroNotFoundException();
        }else{
            return livroJPA;
        }
    }

    @Transactional
    public void salvarSql(AvaliacaoJPA avaliacaoJPA){
        entityManager.persist(avaliacaoJPA);
    }
}
