package com.letras.pfc_letras.facades;

import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.dtos.author.AuthorDto;
import com.letras.pfc_letras.dtos.book.BookDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDto;

import java.util.List;
import java.util.Optional;

public interface Facade {

    List<BookDto> findAllBooks();

    Optional<BookDetailsDto> findBookById(String idBook);

    List<BookDto> findByCategories(String ... paths);

    List<BookDto> searchBookByKey(String text);

    Optional<AuthorDetailsDto> findAuthorById(String idAuthor);

    Optional<AuthorDto> newAuthor(AuthorDto authorDto);
}
