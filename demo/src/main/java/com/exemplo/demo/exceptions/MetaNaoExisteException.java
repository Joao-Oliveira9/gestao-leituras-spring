package com.exemplo.demo.exceptions;

public class MetaNaoExisteException extends RuntimeException {
    public MetaNaoExisteException(String message) {
        super(message);
    }
    public MetaNaoExisteException(){super("meta não existente, livro finalizado");}
}
