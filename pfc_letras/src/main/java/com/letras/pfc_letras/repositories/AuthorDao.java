package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorDao extends MongoRepository<Author, String> {

    List<Author> findByNameContainingIgnoreCase(String name);

    Optional<Author> findByName(String name);
}
