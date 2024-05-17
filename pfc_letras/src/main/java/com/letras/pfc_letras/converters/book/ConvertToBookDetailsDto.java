package com.letras.pfc_letras.converters.book;

import com.letras.pfc_letras.dto.author.AuthorDto;
import com.letras.pfc_letras.dto.book.BookDetailsDto;
import com.letras.pfc_letras.models.AuthorModel;
import com.letras.pfc_letras.models.BookModel;
import jakarta.annotation.Resource;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConvertToBookDetailsDto implements Converter<BookModel, BookDetailsDto>{

    @Resource
    private Converter<AuthorModel, AuthorDto> convertToAuthorDto;

    @Override
    public BookDetailsDto convert(@NonNull BookModel bookModel) {

        return BookDetailsDto.builder()
                             .id(bookModel.getId())
                             .title(bookModel.getTitle())
                             .description(bookModel.getDescription())
                             .publishDate(bookModel.getPublishDate())
                             .image(bookModel.getImage())
                             .category(bookModel.getCategory())
                             .copies(bookModel.getCopies())
                             .isbn(bookModel.getIsbn())
                             .label(bookModel.getLabel())
                             .authorsDto(bookModel.getAuthors()
                                                  .stream()
                                                  .map(convertToAuthorDto::convert)
                                                  .collect(Collectors.toList()))
                             .build();
    }
}
