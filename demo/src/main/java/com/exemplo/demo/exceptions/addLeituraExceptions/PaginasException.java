package com.exemplo.demo.exceptions.addLeituraExceptions;

public class PaginasException extends RuntimeException {
    public PaginasException(String message) {
        super(message);
    }
    public PaginasException(){super("Número de páginas lidas superior ao número de páginas totais");}
}
