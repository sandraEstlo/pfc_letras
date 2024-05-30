package com.letras.pfc_letras.converters.user;

import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.models.UsersModels.UserModel;
import com.letras.pfc_letras.models.UsersModels.UserRoles;
import jakarta.annotation.Resource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class ConvertToUserModel implements Converter<CreateUserDto, UserModel> {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserModel convert(CreateUserDto createUserDto) {

        return UserModel.builder()
                        .username(createUserDto.getUserName())
                        .email(createUserDto.getEmail())
                        .password(passwordEncoder.encode(createUserDto.getPassword()))
                        .roles(Set.of(UserRoles.USER))
                        .build();
    }
}
