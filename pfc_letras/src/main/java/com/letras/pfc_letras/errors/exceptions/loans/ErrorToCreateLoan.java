package com.letras.pfc_letras.errors.exceptions.loans;

public class ErrorToCreateLoan extends RuntimeException {
    public ErrorToCreateLoan() {
        super("Error al crear el prestamo.");
    }

    public ErrorToCreateLoan(String message) {
        super(message);
    }
}
