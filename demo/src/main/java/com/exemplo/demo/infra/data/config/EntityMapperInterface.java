package com.exemplo.demo.infra.data.config;

import com.exemplo.demo.core.domain.entities.Avaliacao;
import com.exemplo.demo.core.domain.entities.Leitura;
import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.entities.MetaLongoPrazo;
import com.exemplo.demo.infra.data.jpa.AvaliacaoJPA;
import com.exemplo.demo.infra.data.jpa.LeituraJPA;
import com.exemplo.demo.infra.data.jpa.LivroJPA;
import com.exemplo.demo.infra.data.jpa.MetaLongoPrazoJPA;

public interface EntityMapperInterface {
    public LivroJPA mapLivro(Livro livro);
    public LeituraJPA mapLeitura(Leitura leitura);
    public MetaLongoPrazoJPA mapLongoPrazo(MetaLongoPrazo metaLongoPrazo, LivroJPA livroJPA);
    public AvaliacaoJPA mapAvaliacao(Avaliacao avaliacao, LivroJPA livroJPA);
}
