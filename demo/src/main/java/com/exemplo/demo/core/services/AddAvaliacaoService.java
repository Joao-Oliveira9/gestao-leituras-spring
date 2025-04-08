package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.usecases.AddAvaliacaoUseCase;
import com.exemplo.demo.presenter.dto.AvaliacaoDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddAvaliacaoService implements AddAvaliacaoUseCase {


    public ResponseEntity<RestMessage> adicionarNota(AvaliacaoDto avaliacaoDto){
        RestMessage message = new RestMessage("SALVE");

        return ResponseEntity.status(HttpStatus.OK).body(message);

    }

    public void verificarNota(){

    }
}
