package com.exemplo.demo.presenter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MetaLongoPrazoDto(LocalDate dataInicio, LocalDate dataPrevista,String nomeLivro,String nomeAutor) {
}
