package com.letras.pfc_letras.errors.exceptions.Author;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(String id) {
        super(String.format("No se pudo encontrar el author con el ID: %s", id));
    }

    public AuthorNotFoundException() {
        super("No se ha podido encontrar autores disponibles.");
    }
}
