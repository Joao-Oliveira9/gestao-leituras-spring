package com.exemplo.demo.infra.Port;

import com.exemplo.demo.core.domain.entities.Livro;
import com.exemplo.demo.core.domain.entities.MetaLongoPrazo;

public interface MetaLongoPrazoRepository {
    public void salvar(MetaLongoPrazo metaLongoPrazo);
}
