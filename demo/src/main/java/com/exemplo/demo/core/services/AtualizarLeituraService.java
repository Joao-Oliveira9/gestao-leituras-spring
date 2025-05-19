package com.exemplo.demo.core.services;

import com.exemplo.demo.core.domain.usecases.AtualizarLeituraUseCase;
import com.exemplo.demo.infra.Port.LeituraRepository;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AtualizarLeituraService implements AtualizarLeituraUseCase {

    LeituraRepository leituraRepository;

    public AtualizarLeituraService(LeituraRepository leituraRepository) {
        this.leituraRepository = leituraRepository;
    }

    public boolean determinarAtualizacaoStatus(){
        return true;
    }

    public ResponseEntity<RestMessage> atualizarPaginas(String nomeLivro,String nomeAutor, int paginaAtualizada){
       leituraRepository.atualizarLeituraEMeta(nomeLivro,nomeAutor, paginaAtualizada);
       RestMessage restMessage = new RestMessage("atualizado com sucesso");
       return ResponseEntity.status(HttpStatus.OK).body(restMessage) ;
    }
}
