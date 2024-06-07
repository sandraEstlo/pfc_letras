package com.letras.pfc_letras.errors.exceptions.User;

public class UserNotFound extends RuntimeException {
    public UserNotFound() {
        super("Usuario no encontrado");
    }
}
