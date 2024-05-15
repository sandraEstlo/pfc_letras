package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<BookModel, String> {

    @Query("{ 'category': { $in: ?0 } }")
    List<BookModel> findByCategories(String ... category);
}
