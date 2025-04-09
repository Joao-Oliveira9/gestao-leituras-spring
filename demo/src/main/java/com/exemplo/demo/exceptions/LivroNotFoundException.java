package com.exemplo.demo.exceptions;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException(){super("Livro não encontrado");}
}
