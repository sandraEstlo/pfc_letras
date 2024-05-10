package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends MongoRepository<Author, String> {

}
