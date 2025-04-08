package com.exemplo.demo.core.domain.entities;

public class Livro {
    String nome;
    String nomeAutor;
    int numPaginas;

    public Livro(){

    }

    public Livro(String nome, String nomeAutor, Integer numPaginas) {
        this.nome = nome;
        this.nomeAutor = nomeAutor;
        this.numPaginas = numPaginas;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }
}
