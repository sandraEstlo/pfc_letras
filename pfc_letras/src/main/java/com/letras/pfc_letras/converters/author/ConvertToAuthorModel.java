package com.letras.pfc_letras.converters.author;

import com.letras.pfc_letras.dtos.author.AuthorDto;
import com.letras.pfc_letras.models.AuthorModel;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToAuthorModel implements Converter<AuthorDto, AuthorModel> {

    @Override
    public AuthorModel convert(@NonNull AuthorDto authorDetailsDto) {
        return AuthorModel.builder()
                          .id(authorDetailsDto.getId())
                          .description(authorDetailsDto.getDescription())
                          .image(authorDetailsDto.getImage())
                          .name(authorDetailsDto.getName())
                          .build();
    }
}
