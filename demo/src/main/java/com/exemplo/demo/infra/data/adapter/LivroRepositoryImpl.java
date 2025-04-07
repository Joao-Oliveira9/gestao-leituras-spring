package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


//tirar notação
@Repository
public class LivroRepositoryImpl implements LivroRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(LivroJPA livro) {
        entityManager.persist(livro); // Insere novo
        // ou: entityManager.merge(aluno); // Insere ou atualiza (mais seguro)
    }
}
