package com.letras.pfc_letras.services;

import com.letras.pfc_letras.models.Author;
import java.util.List;
import java.util.Optional;


public interface AuthorService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(String id);

    Optional<Author> getAuthorByName(String name);

    List<Author> getAuthorByNameContaining(String name);

    Author create(Author author);
}
