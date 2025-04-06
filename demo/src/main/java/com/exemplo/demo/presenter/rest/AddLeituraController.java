package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.presenter.Dto.LeituraDto;
import com.exemplo.demo.presenter.resources.AddLeituraResource;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Map;



public class AddLeituraController implements AddLeituraResource {

    @Override
    public ResponseEntity<RestMessage> postRequestResgistrarLeituraTeste(Map<String, String> teste) {
        System.out.println(teste);
        RestMessage message = new RestMessage("Leitura inserida com sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(message) ;
    }


    public ResponseEntity<RestMessage> postRequestResgistrarLeitura(LeituraDto leitura) {
        System.out.println(leitura.getNomeLivro());
        RestMessage message = new RestMessage("Leitura inserida com sucesso");
        return ResponseEntity.status(HttpStatus.OK).body(message) ;
    }
}
