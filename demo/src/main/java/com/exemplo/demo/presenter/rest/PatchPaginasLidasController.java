package com.exemplo.demo.presenter.rest;

import com.exemplo.demo.core.domain.usecases.AtualizarLeituraUseCase;
import com.exemplo.demo.presenter.dto.LeituraAtualizadaDto;
import com.exemplo.demo.presenter.resources.PatchPaginasLidasResource;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;

public class PatchPaginasLidasController implements PatchPaginasLidasResource {

    AtualizarLeituraUseCase atualizarLeituraUseCase;

    public PatchPaginasLidasController(AtualizarLeituraUseCase atualizarLeituraUseCase){
        this.atualizarLeituraUseCase = atualizarLeituraUseCase;
    }

    @Override
    public ResponseEntity<RestMessage> patchPaginasLidasRequest(LeituraAtualizadaDto leituraAtualizadaDto) {
        System.out.println(leituraAtualizadaDto.paginaAtualizada());
        System.out.println(leituraAtualizadaDto.nomeAutor());
        System.out.println(leituraAtualizadaDto.nomeLivro());


        return   atualizarLeituraUseCase.atualizarPaginas(leituraAtualizadaDto.nomeLivro(), leituraAtualizadaDto.nomeAutor(),Integer.parseInt(leituraAtualizadaDto.paginaAtualizada()));
    }
}
