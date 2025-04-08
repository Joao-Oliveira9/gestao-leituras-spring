package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Avaliacao;

public interface NotaRepository {
    public void salvar(Avaliacao avaliacao);
}
