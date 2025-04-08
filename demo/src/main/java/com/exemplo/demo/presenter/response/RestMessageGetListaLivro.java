package com.exemplo.demo.presenter.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class RestMessageGetListaLivro {
    private final HttpStatus status = HttpStatus.OK;

    private List<Object> livros;

    public RestMessageGetListaLivro(List<Object> livros) {
        this.livros = livros;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<Object> getLivros() {
        return livros;
    }

    public void setLivros(List<Object> livros) {
        this.livros = livros;
    }
}
