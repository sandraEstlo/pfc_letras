package com.letras.pfc_letras.errors.exceptions.Book;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String id) {
        super(String.format("No se pudo encontrar el libro con el ID: %s", id));
    }

    public BookNotFoundException() {
        super("No se ha podido encontrar libros.");
    }
}
