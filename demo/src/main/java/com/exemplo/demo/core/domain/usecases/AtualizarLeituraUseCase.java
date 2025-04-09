package com.exemplo.demo.core.domain.usecases;

import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;

public interface AtualizarLeituraUseCase {
    ResponseEntity<RestMessage> atualizarPaginas(String nomeLivro, String nomeAutor, int paginaAtualizada);
}
