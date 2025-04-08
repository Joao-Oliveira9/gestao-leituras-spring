package com.exemplo.demo.core.services.config;

import com.exemplo.demo.core.domain.usecases.*;
import com.exemplo.demo.core.services.AddAvaliacaoService;
import com.exemplo.demo.core.services.AddLeituraService;
import com.exemplo.demo.core.services.AddMetaLongoPrazoService;
import com.exemplo.demo.core.services.DeleteLivroService;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.infra.Port.LivroRepository;
import com.exemplo.demo.infra.Port.MetaLongoPrazoRepository;
import com.exemplo.demo.infra.Port.NotaRepository;
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

    @Bean
    public DeleteLivroUseCase deleteLivroUseCase(LeituraRepository leituraRepository){
        return new DeleteLivroService(leituraRepository);
    }

    @Bean
    public AddAvaliacaoUseCase addAvaliacaoUseCase(NotaRepository notaRepository){
        return new AddAvaliacaoService(notaRepository);
    }

//    @Bean
//    public GetListaUseCase getListaUseCase(){
//
//    }
}
