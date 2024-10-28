package com.letras.pfc_letras.errors.exceptions.loans;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException() {
        super("El libro no se encuentra disponible");
    }
}
