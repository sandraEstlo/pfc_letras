package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookModel, String> {

}
