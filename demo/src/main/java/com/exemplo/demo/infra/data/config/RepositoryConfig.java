package com.exemplo.demo.infra.data.config;

import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.data.adapter.LeituraRepositoryImpl;
import com.exemplo.demo.infra.data.adapter.LivroRepositoryImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public LivroRepository livroRepository(EntityMapperInterface entityMapper){
        return new LivroRepositoryImpl(entityMapper);
    }

    @Bean
    public LeituraRepository leituraRepository(EntityMapperInterface entityMapper){
        return new LeituraRepositoryImpl(entityMapper);
    }

    @Bean
    public EntityMapperInterface entityMapper(){
        return new EntityMapper();
    }
}
