package com.exemplo.demo.infra.data.adapter;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.data.config.EntityMapper;
import com.exemplo.demo.infra.data.config.EntityMapperInterface;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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

}
