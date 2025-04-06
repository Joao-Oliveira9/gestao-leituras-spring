package com.exemplo.demo.presenter.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeituraDto {
    private String nomeLivro;
    private String numPaginasLivro;
    private String numPaginasLivroLidas;

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getNumPaginasLivro() {
        return numPaginasLivro;
    }

    public String getNumPaginasLivroLidas() {
        return numPaginasLivroLidas;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public void setNumPaginasLivro(String numPaginasLivro) {
        this.numPaginasLivro = numPaginasLivro;
    }

    public void setNumPaginasLivroLidas(String numPaginasLivroLidas) {
        this.numPaginasLivroLidas = numPaginasLivroLidas;
    }
}
