package com.letras.pfc_letras.services.books;

import com.letras.pfc_letras.models.BookModel;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookModel> findAllBooks();

    List<BookModel> findByCategories(String ... paths);

    List<BookModel> findByAuthorNameContainingIgnoreCase(String authorName);

    List<BookModel> findByIdAuthorsContaining(String idAuthor);

    Optional<BookModel> findById(String id);
}
