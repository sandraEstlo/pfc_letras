package com.letras.pfc_letras.services.books;

import com.letras.pfc_letras.models.BookModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookModel> findAllBooks();

    Page<BookModel> findAllBooks(Pageable pageable);

    List<BookModel> findByCategories(List<String> paths);

    List<BookModel> findByAuthorNameContainingIgnoreCase(String authorName);

    List<BookModel> findByIdAuthorsContaining(String idAuthor);

    Optional<BookModel> findById(String id);
}
