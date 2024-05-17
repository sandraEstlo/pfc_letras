package com.letras.pfc_letras.converters.author;

import com.letras.pfc_letras.dto.author.AuthorDto;
import com.letras.pfc_letras.models.AuthorModel;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToAuthorDto implements Converter<AuthorModel, AuthorDto>{

    @Override
    public AuthorDto convert(@NonNull AuthorModel authorModel) {
        return AuthorDto.builder()
                        .id(authorModel.getId())
                        .name(authorModel.getName())
                        .build();
    }
}
