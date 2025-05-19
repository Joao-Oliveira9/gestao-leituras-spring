package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.core.domain.usecases.DeleteLivroUseCase;
import com.exemplo.demo.presenter.dto.LivroDeletarDto;
import com.exemplo.demo.presenter.resources.DeleteLivroResource;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteLivroController implements DeleteLivroResource {

    DeleteLivroUseCase deleteLivroUseCase;
    public DeleteLivroController(DeleteLivroUseCase deleteLivroUseCase){
        this.deleteLivroUseCase = deleteLivroUseCase;
    }

    public ResponseEntity<RestMessage> deleteRequestLivro(LivroDeletarDto livroDeletarDto) {
        System.out.println(livroDeletarDto.nomeLivro());
        System.out.println(livroDeletarDto.nomeAutor());

        System.out.println("passei aqui");

        RestMessage restMessage = new RestMessage("deletado");
        deleteLivroUseCase.deletarLeitura(livroDeletarDto);
        return ResponseEntity.status(HttpStatus.OK).body(restMessage);
    }
}
