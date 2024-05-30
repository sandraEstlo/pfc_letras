package com.letras.pfc_letras.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {

    private String userName;
    private String email;
    private String password;
    private String confirmPassword;
}
