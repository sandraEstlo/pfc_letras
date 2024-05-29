package com.letras.pfc_letras.errors.exceptions.Book;

public class SerchAuthorException extends RuntimeException {

    public SerchAuthorException() {
        super("La búsqueda del autor no produjo resultados.");
    }

    public SerchAuthorException(String txt) {
        super("El termino de búsqueda " + txt + " no produjo resultados.");
    }
}