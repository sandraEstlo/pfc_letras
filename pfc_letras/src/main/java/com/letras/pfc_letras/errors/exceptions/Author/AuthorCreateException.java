package com.letras.pfc_letras.errors.exceptions.Author;

public class AuthorCreateException extends RuntimeException {

    public AuthorCreateException() {
        super("Error al crear el autor");
    }
}
