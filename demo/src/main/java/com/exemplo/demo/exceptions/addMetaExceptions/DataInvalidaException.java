package com.exemplo.demo.exceptions.addMetaExceptions;

public class DataInvalidaException extends RuntimeException {
    public DataInvalidaException(String message) {
        super(message);
    }
    public DataInvalidaException(){super("Data invalida");}
}
