package com.exemplo.demo.core.services.config;

import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.usecases.*;
import com.exemplo.demo.core.services.*;
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
    public DeleteLivroUseCase deleteLivroUseCase(LeituraRepository leituraRepository,LivroRepository livroRepository){
        return new DeleteLivroService(leituraRepository, livroRepository);
    }

    @Bean
    public AddAvaliacaoUseCase addAvaliacaoUseCase(NotaRepository notaRepository){
        return new AddAvaliacaoService(notaRepository);
    }

    @Bean
    public GetListaUseCase getListaUseCase(LeituraRepository leituraRepository){
        return  new GetListaService(leituraRepository);
    }

    @Bean
    public GetListAvaliacaoUseCase getListAvaliacaoUseCase(LivroRepository livroRepository){
        return new GetListaAvaliacaoService(livroRepository);
    }

    @Bean AtualizarLeituraUseCase atualizarLeituraUseCase(LeituraRepository leituraRepository){
        return new AtualizarLeituraService(leituraRepository);
    }
}
