package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class LeituraRepositoryImpl implements LeituraRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(LeituraJPA leituraJPA) {
        entityManager.persist(leituraJPA); // Insere novo
        // ou: entityManager.merge(aluno); // Insere ou atualiza (mais seguro)
    }

}
