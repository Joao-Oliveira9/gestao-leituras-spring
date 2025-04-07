package com.exemplo.demo.core.domain.usecases;

import com.exemplo.demo.core.domain.entities.MetaLongoPrazo;
import com.exemplo.demo.presenter.dto.MetaLongoPrazoDto;

import java.time.LocalDate;

public interface AddMetaLongoPrazoUseCase {
    public void adicionarMeta(MetaLongoPrazoDto metaLongoPrazoDto);
    public boolean verificarDatas(LocalDate dataInicio, LocalDate dataMetaLongoPrazo);
    public MetaLongoPrazo metaMapp(MetaLongoPrazoDto metaLongoPrazoDto);
}
