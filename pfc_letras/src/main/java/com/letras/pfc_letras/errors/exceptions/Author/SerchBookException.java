package com.letras.pfc_letras.errors.exceptions.Author;

public class SerchBookException extends RuntimeException {

    public SerchBookException() {
        super("La búsqueda del libro no produjo resultados.");
    }

    public SerchBookException(String txt) {
        super("El termino de búsqueda " + txt + " no produjo resultados.");
    }
}
