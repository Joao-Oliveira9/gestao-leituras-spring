package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.data.config.EntityMapper;
import com.exemplo.demo.infra.data.config.EntityMapperInterface;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class LeituraRepositoryImpl implements LeituraRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private EntityMapperInterface entityMapper;

    public LeituraRepositoryImpl(EntityMapperInterface entityMapper){
        this.entityMapper = entityMapper;
    }

    public LeituraRepositoryImpl(){

    }

    @Transactional
    public void salvar(Leitura leitura) {
        LeituraJPA leituraJPA = entityMapper.mapLeitura(leitura);

        entityManager.persist(leituraJPA); // Insere novo
        // ou: entityManager.merge(aluno); // Insere ou atualiza (mais seguro)
    }

    @Transactional
    public void deletar(Livro livro){
        String nomeAutor = livro.getNomeAutor();
        String nome = livro.getNome();

        String sql = "SELECT * FROM tb_livro WHERE  nome = :nomeLivro and autor = :nomeAutor ;";
        LivroJPA livroJPA = findLivro(nome,nomeAutor,sql);
        System.out.println(livroJPA.getAutor());
        System.out.println(livroJPA.getLivro_id());
        LeituraJPA leituraJPA = findLeitura(livroJPA.getLivro_id());
        deletarSql(leituraJPA.getLeitura_id());
    }


    @Transactional
    public void deletarSql(UUID leitura_id){
        LeituraJPA leitura = entityManager.find(LeituraJPA.class, leitura_id);
//        entityManager.remove(leitura);
        entityManager.remove(leitura);
    }

    @Transactional
    public LeituraJPA findLeitura(UUID livro_id){
        String sql = "SELECT * FROM tb_leitura WHERE livro_id = :id ;";

        return  (LeituraJPA)entityManager.createNativeQuery(sql, LeituraJPA.class)
                .setParameter("id", livro_id)
                .getResultStream()
                .findFirst()
                .orElse(null);

    }


    @Transactional
    public LivroJPA findLivro(String nomeLivro, String nomeAutor, String sql){
        LivroJPA livroJPA = (LivroJPA) entityManager.createNativeQuery(sql, LivroJPA.class)
                .setParameter("nomeLivro", nomeLivro)
                .setParameter("nomeAutor", nomeAutor)
                .getResultStream()
                .findFirst()
                .orElse(null);
        return livroJPA;
    }
//
//    @Transactional
//    public void deletarSQL(LivroJPA livroJPA){
//        UUID id = livroJPA.getLivro_id();
//        String sql = "Delete from tb_leitura WHERE livro_id = :id";
//        entityManager.createNativeQuery(sql).setParameter("id",id).executeUpdate();;
//
////        entityManager.remove(livroJPA);
//    }
//
//    @Transactional
//    public void deletarSql(UUID leitura_id){
//        LeituraJPA leitura = entityManager.find(LeituraJPA.class, leitura_id);
//        entityManager.remove(leitura);
//    }

}
