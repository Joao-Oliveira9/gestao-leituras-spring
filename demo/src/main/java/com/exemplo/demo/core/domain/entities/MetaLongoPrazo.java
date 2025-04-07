package com.exemplo.demo.core.domain.entities;

import java.time.LocalDate;

public class MetaLongoPrazo {
    String nomeAutor;
    String nomeLivro;
    LocalDate dataInicio;
    LocalDate dataMeta;

    public MetaLongoPrazo(String nomeAutor, String nomeLivro, LocalDate dataInicio, LocalDate dataMeta) {
        this.nomeAutor = nomeAutor;
        this.nomeLivro = nomeLivro;
        this.dataInicio = dataInicio;
        this.dataMeta = dataMeta;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataMeta() {
        return dataMeta;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataMeta(LocalDate dataMeta) {
        this.dataMeta = dataMeta;
    }
}
