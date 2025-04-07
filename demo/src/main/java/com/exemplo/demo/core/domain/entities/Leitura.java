package com.exemplo.demo.core.domain.entities;

import com.exemplo.demo.core.domain.entities.Status.Status;

public class Leitura {
    Livro livro;
    Status status;
    int paginaAtual;
    double porcentagemLeitura;

    public Leitura(Livro livro, Status status, Integer paginaAtual,double porcentagemLeitura) {
        this.livro = livro;
        this.status = status;
        this.paginaAtual = paginaAtual;
        this.porcentagemLeitura = porcentagemLeitura;
    }

    public double getPorcentagemLeitura(){return porcentagemLeitura;}

    public Livro getLivro() {
        return livro;
    }

    public Status getStatus() {
        return status;
    }

    public Integer getPaginaAtual() {
        return paginaAtual;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPaginaAtual(Integer paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public void setPorcentagemLeitura(double porcentagemLeitura){this.porcentagemLeitura = porcentagemLeitura;}
}
