package com.letras.pfc_letras.converters.book;

import com.letras.pfc_letras.dtos.author.AuthorDto;
import com.letras.pfc_letras.dtos.book.BookDetailsDto;
import com.letras.pfc_letras.models.AuthorModel;
import com.letras.pfc_letras.models.BookModel;
import jakarta.annotation.Resource;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConvertToBookModel implements Converter<BookDetailsDto, BookModel> {

    @Resource
    Converter<AuthorDto, AuthorModel> authorConverter;

    @Override
    public BookModel convert(@NonNull BookDetailsDto bookDetailsDto) {
        return BookModel.builder()
                        .id(bookDetailsDto.getId())
                        .description(bookDetailsDto.getDescription())
                        .publishDate(bookDetailsDto.getPublishDate())
                        .image(bookDetailsDto.getImage())
                        .title(bookDetailsDto.getTitle())
                        .category(bookDetailsDto.getCategory())
                        .copies(bookDetailsDto.getCopies())
                        .isbn(bookDetailsDto.getIsbn())
                        .label(bookDetailsDto.getLabel())
                        .authors(bookDetailsDto.getAuthorsDto()
                                               .stream()
                                               .map(authorConverter::convert).collect(Collectors.toList()))
                        .build();
    }
}
