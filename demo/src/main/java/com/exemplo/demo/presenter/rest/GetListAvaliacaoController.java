package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.core.domain.usecases.GetListAvaliacaoUseCase;
import com.exemplo.demo.presenter.resources.GetListAvaliacaoResource;
import com.exemplo.demo.presenter.response.RestMessage;
import com.exemplo.demo.presenter.response.RestMessageGetListaLivro;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetListAvaliacaoController implements GetListAvaliacaoResource {

    GetListAvaliacaoUseCase getListAvaliacaoUseCase;

    public GetListAvaliacaoController(GetListAvaliacaoUseCase getListAvaliacaoUseCase){
        this.getListAvaliacaoUseCase = getListAvaliacaoUseCase;
    }

    public ResponseEntity<RestMessageGetListaLivro> getRequestListaAvaliacao(){
        RestMessage restMessage = new RestMessage("Avaliacao");
        List livros = getListAvaliacaoUseCase.buscandoAvaliacoes();

        RestMessageGetListaLivro restMessageGetLista = new RestMessageGetListaLivro(livros);

        return ResponseEntity.status(HttpStatus.OK).body(restMessageGetLista);
    }


}
