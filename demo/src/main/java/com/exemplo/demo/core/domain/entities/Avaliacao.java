package com.exemplo.demo.core.domain.entities;

import com.exemplo.demo.core.domain.entities.Status.StatusAval;

public class Avaliacao {
    int nota;
    StatusAval statusAval;
    String nomeAutor;
    String nomeLivro;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public StatusAval getStatusAval() {
        return statusAval;
    }

    public void setStatusAval(StatusAval statusAval) {
        this.statusAval = statusAval;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }
}
