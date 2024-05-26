package com.letras.pfc_letras.facades.impl;

import com.letras.pfc_letras.converters.author.ConvertToAuthorDetailsDto;
import com.letras.pfc_letras.converters.book.ConvertToBookDetailsDto;
import com.letras.pfc_letras.converters.book.ConvertToBookDto;
import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.services.AuthorService;
import com.letras.pfc_letras.services.BookSearchService;
import com.letras.pfc_letras.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DefaultFacade implements Facade {

    @Resource
    private BookService bookService;

    @Resource
    private BookSearchService bookSearchService;

    @Resource
    private AuthorService authorService;

    @Resource
    private ConvertToAuthorDetailsDto convertToAuthorDetailsDto;

    @Resource
    private ConvertToBookDto convertToBookDto;

    @Resource
    private ConvertToBookDetailsDto convertToBookDetailsDto;


    @Override
    public List<BookDto> findAllBooks() {
        return bookService.findAllBooks()
                          .stream()
                          .map(convertToBookDto::convert).collect(Collectors.toList());
    }
    @Override
    public Optional<BookDetailsDto> findBookById(String idBook) {
        return bookService.findById(idBook).map(convertToBookDetailsDto::convert);
    }

    @Override
    public List<BookDto> findByCategories(String... paths) {
        return bookService.findByCategories(paths)
                          .stream()
                          .map(convertToBookDto::convert).collect(Collectors.toList());
    }
    @Override
    public List<BookDto> searchBookByKey(String text) {
        return bookSearchService.KeywordsSearch(text)
                                .stream()
                                .map(convertToBookDto::convert).collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorDetailsDto> findAuthorById(String idAuthor) {
        return authorService.findAuthorById(idAuthor)
                            .map(convertToAuthorDetailsDto::convert);
    }
}
