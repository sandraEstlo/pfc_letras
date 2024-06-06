package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.LoanModels.LoanModel;
import jakarta.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends MongoRepository<LoanModel, String> {

    @Query( "{ 'user_id': ?0 }" )
    List<LoanModel> findByUserId(String userid);

    @Aggregation(pipeline = {
            "{ $unwind: '$books_loan' }",
            "{ $match: { 'books_loan.book_id': { $ref: 'book', $id: ObjectId(?0) }, 'books_loan.book_satus': { $in: ['RESERVADO', 'PRESTADO'] } } }",
            "{ $group: { '_id': '$books_loan.book_id', 'actives': { $sum: 1 } } }"
    })
    Optional<Integer> countActivesLoansForBookId(String bookId);

    @Aggregation(pipeline = {
            "{ $match: { 'user_id': ?0, 'books_loan.book_satus': { $in: ['RESERVADO', 'PRESTADO'] } } }",
            "{ $count: 'actives' }"
    })
    Optional<Integer> countActivesLoansForUserId(String userid);
}
