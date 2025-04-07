package com.exemplo.demo.presenter.response;

import com.exemplo.demo.core.domain.entities.Status.Status;
import org.springframework.http.HttpStatus;

public class RestMessageAddLeitura {
    private final HttpStatus status = HttpStatus.OK;

    private Status statusLeitura;

    public RestMessageAddLeitura(Status statusLeitura) {
        this.statusLeitura = statusLeitura;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Status getStatusLeitura() {
        return statusLeitura;
    }

    public void setStatusLeitura(Status statusLeitura) {
        this.statusLeitura = statusLeitura;
    }

}
