package com.letras.pfc_letras.converters.author;

import com.letras.pfc_letras.dto.author.AuthorDetailsDto;
import com.letras.pfc_letras.models.AuthorModel;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToAuthorModel implements Converter<AuthorDetailsDto, AuthorModel> {

    @Override
    public AuthorModel convert(@NonNull AuthorDetailsDto authorDetailsDto) {
        return AuthorModel.builder()
                          .id(authorDetailsDto.getId())
                          .description(authorDetailsDto.getDescription())
                          .name(authorDetailsDto.getName())
                          .build();
    }
}
