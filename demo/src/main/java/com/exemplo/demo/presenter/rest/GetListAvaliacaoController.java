package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.presenter.resources.GetListAvaliacaoResource;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class GetListAvaliacaoController implements GetListAvaliacaoResource {

    public GetListAvaliacaoController(){

    }

    public ResponseEntity<RestMessage> getRequestListaAvaliacao(){
        RestMessage restMessage = new RestMessage("Avaliacao");

        return ResponseEntity.status(HttpStatus.OK).body(restMessage);
    }

}
