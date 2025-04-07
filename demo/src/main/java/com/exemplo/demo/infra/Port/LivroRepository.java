package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository {
    public void salvar(LivroJPA livroJPA);
}
