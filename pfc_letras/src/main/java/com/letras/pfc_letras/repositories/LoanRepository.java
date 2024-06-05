package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.LoanModels.LoanModel;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends MongoRepository<LoanModel, String> {

    @Query( "{ 'user_id': ?0 }" )
    List<LoanModel> findByUserId(String userid);

    @Aggregation(pipeline = {
            "{ $unwind: '$booksLoan' }",
            "{ $match: { 'booksLoan.bookId': { $ref: 'book', $id: ?0 }, 'booksLoan.bookStatus': { $in: ['RESERVADO', 'PRESTADO'] } } }",
            "{ $group: { '_id': '$booksLoan.bookId', 'actives': { $sum: 1 } } }"
    })
    int countActivesLoansForBookId(String bookId);

    @Aggregation(pipeline = {
            "{ $match: { 'user_id': ?0, 'books_loan.book_satus': { $in: ['RESERVADO', 'PRESTADO'] } } }",
            "{ $count: 'actives' }"
    })
    int countActivesLoansForUserId(String userid);
}
