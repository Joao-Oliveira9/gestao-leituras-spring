package com.exemplo.demo.infra.data.dto;

import com.exemplo.demo.core.domain.entities.Status.Status;

public class LivroLeituraView {

    private String nome;
    private String autor;
    private Status status;
    private Integer paginaAtual;
    private Integer qtdPaginas;

    public LivroLeituraView(String nome, String autor, Status status, Integer paginaAtual, Integer qtdPaginas) {
        this.nome = nome;
        this.autor = autor;
        this.status = status;
        this.paginaAtual = paginaAtual;
        this.qtdPaginas = qtdPaginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(Integer paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }
}
