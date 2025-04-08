package com.exemplo.demo.presenter.dto;

import com.exemplo.demo.core.domain.entities.Status.Status;
import org.springframework.http.HttpStatus;

public class LeiturasAndamentoDto {
    private final HttpStatus status = HttpStatus.OK;

    private String nomeLivro;
    private String nomeAutor;
    private Status statusLeitura;
    private Integer paginasLidas;
    private  Integer totalPaginas;

    public LeiturasAndamentoDto(String nomeLivro, String nomeAutor, Status statusLeitura, Integer paginasLidas, Integer totalPaginas) {
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.statusLeitura = statusLeitura;
        this.paginasLidas = paginasLidas;
        this.totalPaginas = totalPaginas;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Status getStatusLeitura() {
        return statusLeitura;
    }

    public void setStatusLeitura(Status statusLeitura) {
        this.statusLeitura = statusLeitura;
    }

    public Integer getPaginasLidas() {
        return paginasLidas;
    }

    public void setPaginasLidas(Integer paginasLidas) {
        this.paginasLidas = paginasLidas;
    }

    public Integer getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(Integer totalPaginas) {
        this.totalPaginas = totalPaginas;
    }
}
