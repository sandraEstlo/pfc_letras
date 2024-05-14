package com.letras.pfc_letras.converters;

import com.letras.pfc_letras.daos.BookDao;
import com.letras.pfc_letras.models.BookModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;
public class ConvertToBookDto implements Converter<BookDao, BookModel> {

    @Override
    public BookModel convert(BookDao bookDao) {

        Assert.notNull(bookDao, "Valor introducido nulo");
        return BookModel.builder()
                .id(bookDao.getId())
                .authors(bookDao.getAuthors())
                .description(bookDao.getDescription())
                .publishDate(bookDao.getPublishDate())
                .subcategoryId(bookDao.getSubcategoryId())
                .copies(bookDao.getCopies())
                .image(bookDao.getImage())
                .title(bookDao.getTitle())
                .isbn(bookDao.getIsbn())
                .label(bookDao.getLabel())
                .build();
    }
}
