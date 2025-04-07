package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.usecases.AddLeituraUseCase;
import com.exemplo.demo.presenter.dto.LeituraDto;
import com.exemplo.demo.presenter.dto.LivroDto;
import com.exemplo.demo.presenter.dto.RegistroLeituraDto;
import com.exemplo.demo.presenter.resources.AddLeituraResource;
import com.exemplo.demo.presenter.response.RestMessage;
import com.exemplo.demo.presenter.response.RestMessageAddLeitura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public class AddLeituraController implements AddLeituraResource {
    AddLeituraUseCase addLeituraUseCase;

    public AddLeituraController(AddLeituraUseCase addLeituraUseCase){
        this.addLeituraUseCase = addLeituraUseCase;
    }

    public ResponseEntity<RestMessageAddLeitura> postRequestResgistrarLeitura(RegistroLeituraDto registroLeituraDto) {
        LeituraDto leitura  = registroLeituraDto.leitura();
        LivroDto livro = registroLeituraDto.livro();
        System.out.println(leitura.paginasLidas());
        return addLeituraUseCase.adicionarLeitura(leitura,livro);
    }

}
