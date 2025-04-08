package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.data.config.EntityMapper;
import com.exemplo.demo.infra.data.config.EntityMapperInterface;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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

//    @Transactional
//    public void deletar(Livro livro){
//        String nomeAutor = livro.getNomeAutor();
//        String nome = livro.getNome();
//
//        String sql = "SELECT * FROM tb_livro WHERE  nome = :nomeLivro and autor = :nomeAutor ;";
//        LivroJPA livroJPA = teste(nome,nomeAutor,sql);
//        System.out.println(livroJPA.getAutor());
//        System.out.println(livroJPA.getLivro_id());
//        deletarSQL(livroJPA);
//    }
//
//    @Transactional
//    public LivroJPA teste(String nomeLivro, String nomeAutor, String sql){
//        LivroJPA livroJPA = (LivroJPA) entityManager.createNativeQuery(sql, LivroJPA.class)
//                .setParameter("nomeLivro", nomeLivro)
//                .setParameter("nomeAutor", nomeAutor)
//                .getResultStream()
//                .findFirst()
//                .orElse(null);
//        return livroJPA;
//    }
//
//    @Transactional
//    public void deletarSQL(LivroJPA livroJPA){
//        UUID id = livroJPA.getLivro_id();
//        String sql = "Delete from tb_livro WHERE livro_id = :id";
//        entityManager.createNativeQuery(sql).setParameter("id",id).getResultStream().findFirst().orElse(null);
//
////        entityManager.remove(livroJPA);
//    }
}
