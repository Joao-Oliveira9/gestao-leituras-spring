package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface LeituraRepository  {
    public void salvar(Leitura leitura);
    public void deletar(Livro livro);
}
