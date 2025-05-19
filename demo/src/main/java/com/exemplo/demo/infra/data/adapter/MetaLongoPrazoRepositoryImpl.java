package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.MetaLongoPrazo;
import com.exemplo.demo.exceptions.LivroNotFoundException;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.Port.MetaLongoPrazoRepository;
import com.exemplo.demo.infra.data.config.EntityMapperInterface;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import com.exemplo.demo.infra.data.jpa.MetaLongoPrazoJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class MetaLongoPrazoRepositoryImpl implements MetaLongoPrazoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private EntityMapperInterface entityMapper;


    LivroRepository livroRepository;

    public MetaLongoPrazoRepositoryImpl(EntityMapperInterface entityMapper,LivroRepository livroRepository) {
        this.entityMapper = entityMapper;
    }

    @Transactional
    public void salvar(MetaLongoPrazo metaLongoPrazo){
//        String sql = "SELECT * FROM tb_livro WHERE  nome = 'Vagabond' and autor = 'Takohike Inoue';";


        String sql = "SELECT * FROM tb_livro WHERE  nome = :nomeLivro and autor = :nomeAutor ;";

        String nomeLivro = metaLongoPrazo.getNomeLivro();
        String nomeAutor = metaLongoPrazo.getNomeAutor();


        LivroJPA livroJPA = salvarBd(nomeLivro,nomeAutor,sql);
        MetaLongoPrazoJPA metaLongoPrazoJPA = entityMapper.mapLongoPrazo(metaLongoPrazo,livroJPA);
        System.out.println(livroJPA.getAutor());


        entityManager.persist(metaLongoPrazoJPA);
        System.out.println(livroJPA.getAutor());

    }

//trocar nome -  funcao que busca livro baseado no autor e no nomeLivro --- preciso mudar o nome
    public LivroJPA salvarBd(String nomeLivro,String nomeAutor,String sql){

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
