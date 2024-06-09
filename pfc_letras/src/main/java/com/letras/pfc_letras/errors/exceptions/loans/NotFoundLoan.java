package com.letras.pfc_letras.errors.exceptions.loans;

public class NotFoundLoan extends RuntimeException {
    public NotFoundLoan() {
        super("El prestamo buscado no se encuentra registrado.");
    }
}
