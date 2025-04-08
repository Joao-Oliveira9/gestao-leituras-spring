package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.core.domain.usecases.AddMetaLongoPrazoUseCase;
import com.exemplo.demo.presenter.dto.MetaLongoPrazoDto;
import com.exemplo.demo.presenter.resources.AddMetaLongoPrazoResource;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class AddMetaLongoPrazoController implements AddMetaLongoPrazoResource {

    AddMetaLongoPrazoUseCase addMetaLongoPrazoUseCase;

    public AddMetaLongoPrazoController(AddMetaLongoPrazoUseCase addMetaLongoPrazoUseCase){
        this.addMetaLongoPrazoUseCase = addMetaLongoPrazoUseCase;
    }

    public ResponseEntity<RestMessage> postRequestMetaLongoPrazo(MetaLongoPrazoDto metaLongoPrazo){

        addMetaLongoPrazoUseCase.adicionarMeta(metaLongoPrazo);

        RestMessage message = new RestMessage("Data cadastrada");
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
