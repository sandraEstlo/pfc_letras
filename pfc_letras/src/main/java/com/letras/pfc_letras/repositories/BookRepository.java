package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.BookModel;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<BookModel, String> {

    @Query("{ 'category': { $in: ?0 } }")
    List<BookModel> findByCategories(String ... category);

    @Aggregation(pipeline = {
            "{ '$lookup': { 'from': 'author', 'localField': 'authors', 'foreignField': '_id', 'as': 'authorDetails' } }",
            "{ '$unwind': '$authorDetails' }",
            "{ '$match':  { 'authorDetails.name': { $regex: ?0, $options: 'i' } } }"
    })
    List<BookModel> findByAuthorsNameContainingIgnoreCase(String authorName);

    @Query("{ 'authors':  {'$oid': ?0 }}")
    List<BookModel> findByAuthorsContaining(String authors);

    @Query("{'_id': {'$oid': ?0 }}")
    Optional<BookModel> findById(@NonNull String id);
}
