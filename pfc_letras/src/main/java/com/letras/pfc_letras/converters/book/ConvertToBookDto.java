package com.letras.pfc_letras.converters.book;

import com.letras.pfc_letras.models.AuthorModel;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.models.BookModel;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class ConvertToBookDto implements Converter<BookModel, BookDto> {

    @Override
    public BookDto convert(@NonNull BookModel bookModel) {
        return BookDto.builder()
                      .id(bookModel.getId())
                      .title(bookModel.getTitle())
                      .image(bookModel.getImage())
                      .category(bookModel.getCategory())
                      .authorsNames(bookModel.getAuthors()
                              .stream().map(AuthorModel::getName).collect(Collectors.joining(", ")))
                      .build();
    }
}
