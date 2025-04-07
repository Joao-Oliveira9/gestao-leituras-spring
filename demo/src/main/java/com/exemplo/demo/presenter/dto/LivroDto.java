package com.exemplo.demo.presenter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDto(String nomeAutor,String nomeLivro,String numPaginasLivro){


}
