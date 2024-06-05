package com.letras.pfc_letras.errors.exceptions.User;

import com.letras.pfc_letras.dtos.user.CreateUserDto;
import lombok.Getter;

@Getter
public class NewUserWithDifferentPassword extends RuntimeException {
    private final CreateUserDto createUserDto;

    public NewUserWithDifferentPassword() {
        super("Las contraseñas deben ser iguales.");
        this.createUserDto = null;
    }

    public NewUserWithDifferentPassword(CreateUserDto createUserDto) {
        super("Las contraseñas deben ser iguales.");
        this.createUserDto = createUserDto;
    }
}
