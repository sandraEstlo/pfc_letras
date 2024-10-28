package com.letras.pfc_letras.converters.author;

import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.models.AuthorModel;
import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.services.books.BookService;
import jakarta.annotation.Resource;
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
    public AuthorDetailsDto convert(AuthorModel authorModel) {
        return AuthorDetailsDto.builder()
                               .id(authorModel.getId())
                               .name(authorModel.getName())
                               .description(authorModel.getDescription())
                               .image(authorModel.getImage())
                               .booksDto(bookService.findByIdAuthorsContaining(authorModel.getId())
                                                                                          .stream()
                                                                                          .map(convertToBookDto::convert)
                                                                                          .collect(Collectors.toList()))
                               .build();
    }
}
