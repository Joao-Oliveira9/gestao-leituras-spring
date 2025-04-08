package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.core.domain.usecases.AddAvaliacaoUseCase;
import com.exemplo.demo.presenter.dto.AvaliacaoDto;
import com.exemplo.demo.presenter.resources.AddAvaliacaoResource;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class AddAvaliacaoController implements AddAvaliacaoResource {

    AddAvaliacaoUseCase addAvaliacaoUseCase;

    public AddAvaliacaoController(AddAvaliacaoUseCase addAvaliacaoUseCase){
        this.addAvaliacaoUseCase = addAvaliacaoUseCase;

    }

    public ResponseEntity<RestMessage> postRequestRegistrarAvaliacao(AvaliacaoDto avaliacaoDto) {
        System.out.println(avaliacaoDto.nomeLivro());
        System.out.println(avaliacaoDto.nota());
        System.out.println(avaliacaoDto.nomeLivro());

//        RestMessage message = new RestMessage("Deu certo");
        return addAvaliacaoUseCase.adicionarNota(avaliacaoDto);
    }
}
