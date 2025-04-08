package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.core.domain.usecases.GetListaUseCase;
import com.exemplo.demo.presenter.resources.GetListLeituraResource;
import com.exemplo.demo.presenter.response.RestMessage;
import com.exemplo.demo.presenter.response.RestMessageGetListaLivro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetListLeituraController implements GetListLeituraResource {

    GetListaUseCase getListaUseCase;

    public GetListLeituraController(GetListaUseCase getListaUseCase){
        this.getListaUseCase = getListaUseCase;
    }

    public ResponseEntity<RestMessageGetListaLivro> getRequestListaController(){
        RestMessage restMessage = new RestMessage("ListaLeituras");
        List livros = getListaUseCase.buscarLivrosEmProgresso();

        RestMessageGetListaLivro restMessageGetListaLivroEmAndamento = new RestMessageGetListaLivro(livros);

        return ResponseEntity.status(HttpStatus.OK).body(restMessageGetListaLivroEmAndamento);
    }
}
