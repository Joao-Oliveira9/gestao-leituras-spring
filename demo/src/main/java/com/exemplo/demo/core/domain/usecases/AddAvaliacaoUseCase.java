package com.exemplo.demo.core.domain.usecases;

import com.exemplo.demo.presenter.dto.AvaliacaoDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;

public interface AddAvaliacaoUseCase {
    public ResponseEntity<RestMessage> adicionarNota(AvaliacaoDto avaliacaoDto);
}
