package com.letras.pfc_letras.converters.user;

import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.models.UsersModels.UserModel;
import com.letras.pfc_letras.models.UsersModels.UserRoles;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class ConvertToUserModel implements Converter<CreateUserDto, UserModel> {

    @Override
    public UserModel convert(CreateUserDto createUserDto) {

        return UserModel.builder()
                        .username(createUserDto.getUserName())
                        .email(createUserDto.getEmail())
                        .password(createUserDto.getPassword())
                        .roles(Set.of(UserRoles.USER))
                        .build();
    }
}
