package com.letras.pfc_letras.errors.exceptions.Book;

public class BookCreateException extends RuntimeException {

    public BookCreateException() {
        super("Error al crear el libro");
    }
}
