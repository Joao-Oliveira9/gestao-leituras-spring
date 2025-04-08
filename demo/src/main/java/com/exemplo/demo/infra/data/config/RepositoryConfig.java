package com.exemplo.demo.infra.data.config;

import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.Port.MetaLongoPrazoRepository;
import com.exemplo.demo.infra.Port.NotaRepository;
import com.exemplo.demo.infra.data.adapter.LeituraRepositoryImpl;
import com.exemplo.demo.infra.data.adapter.LivroRepositoryImpl;
import com.exemplo.demo.infra.data.adapter.MetaLongoPrazoRepositoryImpl;
import com.exemplo.demo.infra.data.adapter.NotaRepositoryImpl;
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
    public MetaLongoPrazoRepository metaLongoPrazoRepository(EntityMapperInterface entityMapper,LivroRepository livroRepository){
        return new MetaLongoPrazoRepositoryImpl(entityMapper,livroRepository);
    }

    @Bean
    public EntityMapperInterface entityMapper(){
        return new EntityMapper();
    }

    @Bean
    public NotaRepository notaRepository(EntityMapperInterface entityMapper,LivroRepository livroRepository){
        return new NotaRepositoryImpl(entityMapper,livroRepository);
    }
}
