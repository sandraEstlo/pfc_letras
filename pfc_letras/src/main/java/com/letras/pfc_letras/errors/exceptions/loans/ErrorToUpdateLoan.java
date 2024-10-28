package com.letras.pfc_letras.errors.exceptions.loans;

public class ErrorToUpdateLoan extends RuntimeException {

    public ErrorToUpdateLoan() {
        super("Error al actualizar loan");
    }
}
