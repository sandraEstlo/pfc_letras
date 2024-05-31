package com.letras.pfc_letras.converters.user;

import com.letras.pfc_letras.dtos.user.GetUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ConvertToGetUserDto implements Converter<UserDetails, GetUserDto> {

    @Override
    public GetUserDto convert(UserDetails userDetails) {
          return GetUserDto.builder()
                           .userName(userDetails.getUsername())
                           .roles(userDetails.getAuthorities().stream()
                                             .map(GrantedAuthority::getAuthority).collect(Collectors.toSet()))
                           .build();
    }
}
