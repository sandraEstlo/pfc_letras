package com.letras.pfc_letras.errors.exceptions.User;

public class NewUserWithDifferentPassword extends RuntimeException {

    public NewUserWithDifferentPassword() {
        super("Las contraseñas deben ser iguales.");
    }
}
