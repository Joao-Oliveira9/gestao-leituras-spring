package com.exemplo.demo.presenter.config;

import com.exemplo.demo.core.domain.usecases.AddAvaliacaoUseCase;
import com.exemplo.demo.core.domain.usecases.AddLeituraUseCase;
import com.exemplo.demo.core.domain.usecases.AddMetaLongoPrazoUseCase;
import com.exemplo.demo.core.domain.usecases.DeleteLivroUseCase;
import com.exemplo.demo.presenter.rest.AddAvaliacaoController;
import com.exemplo.demo.presenter.rest.AddLeituraController;
import com.exemplo.demo.presenter.rest.AddMetaLongoPrazoController;
import com.exemplo.demo.presenter.rest.DeleteLivroController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class RestConfig {

    @Bean
    public AddLeituraController addLeituraController(AddLeituraUseCase addLeituraUseCase){
        return new AddLeituraController(addLeituraUseCase);
    }

    @Bean
    public AddMetaLongoPrazoController addMetaLongoPrazoController(AddMetaLongoPrazoUseCase addMetaLongoPrazoUseCase){
        return new AddMetaLongoPrazoController(addMetaLongoPrazoUseCase);
    }

    @Bean
    public DeleteLivroController deleteLivroController(DeleteLivroUseCase deleteLivroUseCase){
        return new DeleteLivroController(deleteLivroUseCase);
    }

    @Bean
    public AddAvaliacaoController addAvaliacaoController(AddAvaliacaoUseCase addAvaliacaoUseCase){
        return new AddAvaliacaoController(addAvaliacaoUseCase);
    }

}
