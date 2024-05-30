package com.letras.pfc_letras.errors.exceptions;

public class NewUserWithDifferentPassword extends RuntimeException {

    public NewUserWithDifferentPassword() {
        super("Las contraseñas no coinciden");
    }
}
