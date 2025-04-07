package com.exemplo.demo.core.domain.usecases;

import com.exemplo.demo.core.domain.entities.MetaLongoPrazo;
import com.exemplo.demo.presenter.dto.MetaLongoPrazoDto;
import com.exemplo.demo.presenter.response.RestMessage;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface AddMetaLongoPrazoUseCase {
    public ResponseEntity<RestMessage> adicionarMeta(MetaLongoPrazoDto metaLongoPrazoDto);
    public boolean verificarDatas(LocalDate dataInicio, LocalDate dataMetaLongoPrazo);
    public MetaLongoPrazo metaMapp(MetaLongoPrazoDto metaLongoPrazoDto);
}
