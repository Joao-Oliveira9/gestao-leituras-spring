package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.entities.Status.Status;
import com.exemplo.demo.core.domain.entities.Status.StatusMeta;
import com.exemplo.demo.exceptions.LivroNotFoundException;
import com.exemplo.demo.exceptions.MetaNaoExisteException;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.data.dto.LivroLeituraView;
import com.exemplo.demo.infra.data.config.EntityMapperInterface;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import com.exemplo.demo.infra.data.jpa.MetaLongoPrazoJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
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
//        LeituraJPA leituraJPA = findLeitura(livroJPA.getLivro_id());
//        deletarSql(leituraJPA.getLeitura_id());

        deletarLivroPorId(livroJPA.getLivro_id());
//        deletarPorLivroId(livroJPA.getLivro_id());
    }



    @Transactional
    public void deletarPorLivroId(UUID livroId) {
        String jpql = "DELETE FROM LeituraJPA l WHERE l.livroJPA.livro_id = :livroId";

        entityManager.createQuery(jpql)
                .setParameter("livroId", livroId)
                .executeUpdate();
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

//    @Transactional
//    public void deletarSql(UUID leitura_id){
//        LeituraJPA leitura = entityManager.find(LeituraJPA.class, leitura_id);
////        entityManager.remove(leitura);
//        entityManager.remove(leitura);
//    }

//    @Transactional
//    public LeituraJPA findLeitura(UUID livro_id){
//        String sql = "SELECT * FROM tb_leitura WHERE livro_id = :id ;";
//
//        return  (LeituraJPA)entityManager.createNativeQuery(sql, LeituraJPA.class)
//                .setParameter("id", livro_id)
//                .getResultStream()
//                .findFirst()
//                .orElse(null);
//
//    }


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


    //Get Lista


//    List<LivroLeituraView>
    public List<LivroLeituraView> buscarLivrosEmProgresso() {
        List<LivroLeituraView> livros = entityManager.createQuery("""
            SELECT
                l.livroJPA.nome AS nome,
                l.livroJPA.autor AS autor,
                l.status AS status,
                l.paginaAtual AS paginaAtual,
                l.livroJPA.qtdPaginas AS qtdPaginas
            FROM LeituraJPA l
        """, LivroLeituraView.class).getResultList();


        System.out.println(livros);
        System.out.println("Passei aqui");

        for (LivroLeituraView livro : livros) {
            System.out.println("Livro: " + livro.getNome());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Status: " + livro.getStatus());
            System.out.println("Páginas lidas: " + livro.getPaginaAtual());
            System.out.println("Total de páginas: " + livro.getQtdPaginas());
            System.out.println("--------------------------------");
        }
        return livros;
    }


//    @Transactional
//    public void atualizarLeituraEMetaBd(String nomeLivro, String nomeAutor, int paginaAtualizada) {
//        LocalDate hoje = LocalDate.now();
//        System.out.println("meus zovo1");
//
//        // 1. Buscar o livro
//        String hqlLivro = """
//            SELECT l FROM LivroJPA l
//            WHERE l.nome = :nomeLivro AND l.autor = :nomeAutor
//            """;
//
////        LivroJPA livro = entityManager.createQuery(hqlLivro, LivroJPA.class)
////                .setParameter("nomeLivro", nomeLivro)
////                .setParameter("nomeAutor", nomeAutor)
////                .getSingleResult();
//
//        LivroJPA livro = null;
//        try {
//             livro = entityManager.createQuery(hqlLivro, LivroJPA.class)
//                    .setParameter("nomeLivro", nomeLivro)
//                    .setParameter("nomeAutor", nomeAutor)
//                    .getSingleResult();
//        } catch (NoResultException e) {
//            throw new LivroNotFoundException();
//        }
//
//        // 2. Atualizar leitura
//        LeituraJPA leitura = null;
//        if(livro !=null){
//             leitura = livro.getLeituraJPA();
//        }
//        else{
//            throw new LivroNotFoundException();
//        }
//
//        if (leitura != null && paginaAtualizada <= livro.getQtdPaginas()) {
//            leitura.setPaginaAtual(paginaAtualizada);
//            System.out.println(leitura.getPaginaAtual());
//            entityManager.merge(leitura);
//        }
//        else{
//            throw new LivroNotFoundException();
//        }
//        System.out.println("meus zovo");
//
//        // 3. Atualizar meta
//        MetaLongoPrazoJPA meta = livro.getMetaLongoPrazoJPA();
//        if (meta != null) {
//            if (hoje.isAfter(meta.getData_meta())) {
//                meta.setStatusMeta(StatusMeta.META_FALHADA);
//            } else {
//                meta.setStatusMeta(StatusMeta.META_CUMPRIDA);
//            }
//            entityManager.merge(meta);
//        }else{
//            throw new MetaNaoExisteException();
//        }
//
//    }
@Transactional
public void atualizarLeituraEMetaBd(String nomeLivro, String nomeAutor, int paginaAtualizada) {
    LocalDate hoje = LocalDate.now();

    // 1. Buscar o livro
    String hqlLivro = """
        SELECT l FROM LivroJPA l
        WHERE l.nome = :nomeLivro AND l.autor = :nomeAutor
        """;

    LivroJPA livro;
    try {
        livro = entityManager.createQuery(hqlLivro, LivroJPA.class)
                .setParameter("nomeLivro", nomeLivro)
                .setParameter("nomeAutor", nomeAutor)
                .getSingleResult();
    } catch (NoResultException e) {
        throw new LivroNotFoundException();
    }

    // 2. Atualizar leitura
    LeituraJPA leitura = livro.getLeituraJPA();
    if (leitura == null) {
        throw new LivroNotFoundException();
    }

    if (paginaAtualizada <= livro.getQtdPaginas()) {
        leitura.setPaginaAtual(paginaAtualizada);

        // Atualiza o status da leitura
        if (paginaAtualizada >= livro.getQtdPaginas()) {
            leitura.setStatus(Status.Finalizado); // Substitua pelo valor real do seu enum
        } else {
            leitura.setStatus(Status.EmAndamento); // Se tiver esse valor no seu enum
        }

        entityManager.merge(leitura);
    } else {
        throw new IllegalArgumentException("Número de páginas lidas maior que o total de páginas do livro.");
    }

    // 3. Atualizar meta
    MetaLongoPrazoJPA meta = livro.getMetaLongoPrazoJPA();
    if (meta != null) {
        if (hoje.isAfter(meta.getData_meta())) {
            meta.setStatusMeta(StatusMeta.META_FALHADA);
        } else {
            meta.setStatusMeta(StatusMeta.META_CUMPRIDA);
        }
        entityManager.merge(meta);
    } else {
        throw new MetaNaoExisteException();
    }
}



}
