package com.exemplo.demo.infra.data.config;

import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;

public interface EntityMapperInterface {
    public LivroJPA mapLivro(Livro livro);
    public LeituraJPA mapLeitura(Leitura leitura);
}
