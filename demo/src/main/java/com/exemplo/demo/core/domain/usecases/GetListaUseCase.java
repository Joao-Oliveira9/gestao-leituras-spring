package com.exemplo.demo.core.domain.usecases;

import com.exemplo.demo.infra.data.Dto.LivroLeituraView;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetListaUseCase {
    public List<LivroLeituraView> buscarLivrosEmProgresso();
//      public void buscarLivrosEmProgresso();
}
