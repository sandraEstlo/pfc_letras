package com.letras.pfc_letras.errors.exceptions.loans;

public class UserNotAvailableException extends RuntimeException {
    public UserNotAvailableException() {
        super("El usuario ya tiene activos el número máximo de prestamos.");
    }
}
