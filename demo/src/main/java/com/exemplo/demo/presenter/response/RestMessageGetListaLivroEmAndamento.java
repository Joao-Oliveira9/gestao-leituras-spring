package com.exemplo.demo.presenter.response;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

public class RestMessageGetListaLivroEmAndamento {
    private final HttpStatus status = HttpStatus.OK;

    private List<Object> livros;

    public RestMessageGetListaLivroEmAndamento(List<Object> livros) {
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
