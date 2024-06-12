package com.letras.pfc_letras.converters.user;

import com.letras.pfc_letras.dtos.user.GetUserDto;
import com.letras.pfc_letras.models.users.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ConvertToGetUserDto implements Converter<UserModel, GetUserDto> {

    @Override
    public GetUserDto convert(UserModel userModel) {
          return GetUserDto.builder()
                           .id(userModel.getId())
                           .userName(userModel.getUsername())
                           .roles(userModel.getAuthorities().stream()
                                             .map(GrantedAuthority::getAuthority).collect(Collectors.toSet()))
                           .build();
    }
}
