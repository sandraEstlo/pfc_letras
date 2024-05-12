package com.letras.pfc_letras.services;

import com.letras.pfc_letras.models.AuthorModel;
import java.util.List;
import java.util.Optional;


public interface AuthorService {

    List<AuthorModel> findAllAuthors();

    Optional<AuthorModel> findAuthorById(String id);

    Optional<AuthorModel> findAuthorByName(String name);

    List<AuthorModel> findAuthorByNameContaining(String name);

    AuthorModel save(AuthorModel author);
}
