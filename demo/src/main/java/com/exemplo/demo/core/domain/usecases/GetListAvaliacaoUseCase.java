package com.exemplo.demo.core.domain.usecases;

import com.exemplo.demo.infra.data.dto.LivroAvaliacaoView;

import java.util.List;

public interface GetListAvaliacaoUseCase {
//    public void buscandoAvaliacoes();
//    public void buscandoAvaliacoes();
    public List<LivroAvaliacaoView> buscandoAvaliacoes();
}
