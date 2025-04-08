package com.exemplo.demo.infra.data.dto;

public class LivroAvaliacaoView {

    private String nome;
    private String autor;
    private double nota;

    public LivroAvaliacaoView(String nome, String autor, double nota) {
        this.nome = nome;
        this.autor = autor;
        this.nota = nota;
    }

    public String getNome() { return nome; }
    public String getAutor() { return autor; }
    public double getNota() { return nota; }

    public void setNome(String nome) { this.nome = nome; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setNota(double nota) { this.nota = nota; }
}