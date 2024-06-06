package com.letras.pfc_letras.errors.exceptions.loans;

public class ErrorToConverterModel extends RuntimeException {
    public ErrorToConverterModel() {
        super("Ha ocurrido un error al recibir el prestamo");
    }
}
