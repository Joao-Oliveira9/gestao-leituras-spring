package com.exemplo.demo.presenter.config;

import com.exemplo.demo.core.domain.usecases.*;
import com.exemplo.demo.presenter.rest.*;
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

    @Bean
    public GetListAvaliacaoController getListAvaliacaoController(GetListAvaliacaoUseCase getListAvaliacaoUseCase){
        return new GetListAvaliacaoController(getListAvaliacaoUseCase);
    }

    @Bean
    public GetListLeituraController getListLeituraController(GetListaUseCase getListaUseCase){
        return new GetListLeituraController(getListaUseCase);
    }

    @Bean
    public PatchPaginasLidasController patchPaginasLidasController(AtualizarLeituraUseCase atualizarLeituraUseCase){
        return new PatchPaginasLidasController(atualizarLeituraUseCase);
    }

}
