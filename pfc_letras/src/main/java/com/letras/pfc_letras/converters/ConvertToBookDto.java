package com.letras.pfc_letras.converters;

import com.letras.pfc_letras.models.dto.BookDto;
import com.letras.pfc_letras.models.BookModel;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;
public class ConvertToBookDto implements Converter<BookDto, BookModel> {

    @Override
    public BookModel convert(@NonNull BookDto bookDto) {

        Assert.notNull(bookDto, "BookDto must not be null");
        return BookModel.builder()
                .id(bookDto.getId())
                .authors(bookDto.getAuthors())
                .description(bookDto.getDescription())
                .publishDate(bookDto.getPublishDate())
                .category(bookDto.getCategory())
                .copies(bookDto.getCopies())
                .image(bookDto.getImage())
                .title(bookDto.getTitle())
                .isbn(bookDto.getIsbn())
                .label(bookDto.getLabel())
                .build();
    }
}
