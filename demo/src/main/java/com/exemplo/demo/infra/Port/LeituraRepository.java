package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import org.springframework.stereotype.Repository;


public interface LeituraRepository {
    public void salvar(Leitura leitura);
}
