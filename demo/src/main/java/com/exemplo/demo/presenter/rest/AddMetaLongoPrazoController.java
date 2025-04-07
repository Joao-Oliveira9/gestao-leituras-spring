package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.core.domain.usecases.AddMetaLongoPrazoUseCase;
import com.exemplo.demo.presenter.dto.MetaLongoPrazoDto;
import com.exemplo.demo.presenter.resources.addMetaLongoPrazoResource;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


public class AddMetaLongoPrazoController implements addMetaLongoPrazoResource {

    AddMetaLongoPrazoUseCase addMetaLongoPrazoUseCase;

    public AddMetaLongoPrazoController(AddMetaLongoPrazoUseCase addMetaLongoPrazoUseCase){
        this.addMetaLongoPrazoUseCase = addMetaLongoPrazoUseCase;
    }

    public ResponseEntity<RestMessage> postRequestMetaLongoPrazo(MetaLongoPrazoDto metaLongoPrazo){
//        System.out.println(metaLongoPrazo.dataInicio());
//        System.out.println(metaLongoPrazo.dataPrevista());
//        System.out.println(metaLongoPrazo.nomeAutor());
//        System.out.println(metaLongoPrazo.nomeLivro());

        addMetaLongoPrazoUseCase.adicionarMeta(metaLongoPrazo);

        RestMessage message = new RestMessage("Data cadastrada");
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
