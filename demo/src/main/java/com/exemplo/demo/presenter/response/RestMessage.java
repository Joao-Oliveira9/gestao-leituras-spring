package com.exemplo.demo.presenter.response;

import org.springframework.http.HttpStatus;


public class RestMessage {
    private final HttpStatus status = HttpStatus.OK;
    private String message;

    public RestMessage(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
