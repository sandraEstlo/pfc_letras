package com.letras.pfc_letras.converters.author;

import com.letras.pfc_letras.dto.author.AuthorDetailsDto;
import com.letras.pfc_letras.dto.book.BookDto;
import com.letras.pfc_letras.models.AuthorModel;
import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.services.BookService;
import jakarta.annotation.Resource;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ConvertToAuthorDetailsDto implements Converter<AuthorModel, AuthorDetailsDto> {

    @Resource
    private BookService bookService;

    @Resource
    private Converter<BookModel, BookDto> convertToBookDto;

    @Override
    public AuthorDetailsDto convert(@NonNull AuthorModel authorModel) {
        return AuthorDetailsDto.builder()
                               .id(authorModel.getId())
                               .name(authorModel.getName())
                               .description(authorModel.getDescription())
                               .booksDto(bookService.findByAuthorsContaining(authorModel.getId())
                                                                                        .stream()
                                                                                        .map(convertToBookDto::convert)
                                                                                        .collect(Collectors.toList()))
                               .build();
    }
}
