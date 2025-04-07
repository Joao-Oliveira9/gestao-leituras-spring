package com.exemplo.demo.core.services.config;

import com.exemplo.demo.core.domain.usecases.AddLeituraUseCase;
import com.exemplo.demo.core.domain.usecases.AddMetaLongoPrazoUseCase;
import com.exemplo.demo.core.services.AddLeituraService;
import com.exemplo.demo.core.services.AddMetaLongoPrazoService;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.Port.MetaLongoPrazoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AddLeituraUseCase addLeituraUseCase(LeituraRepository leituraRepository, LivroRepository livroRepository){
        return new AddLeituraService(leituraRepository, livroRepository);
    }

    @Bean
    public AddMetaLongoPrazoUseCase addMetaLongoPrazoUseCase(MetaLongoPrazoRepository metaLongoPrazoRepository){
        return new AddMetaLongoPrazoService(metaLongoPrazoRepository);
    }
}
