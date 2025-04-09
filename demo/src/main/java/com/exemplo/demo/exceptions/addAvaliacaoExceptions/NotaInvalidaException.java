package com.exemplo.demo.exceptions.addAvaliacaoExceptions;

public class NotaInvalidaException extends RuntimeException {
    public NotaInvalidaException(String message) {
        super(message);
    }
    public NotaInvalidaException(){super("valor da nota invalido");}
}
