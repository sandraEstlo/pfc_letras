package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.loans.LoanModel;
import com.letras.pfc_letras.models.loans.ViewLoanModel;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends MongoRepository<LoanModel, String> {

    @Aggregation(pipeline = {
            "{ $unwind: '$books_loan' }",
            "{ $lookup: { from: 'book', localField: 'books_loan.book_id.$id', foreignField: '_id', as: 'booksloan' } }",
            "{ $unwind: '$booksloan' }",
            "{ $match: {'books_loan.book_satus': {$in: ?1}, 'user_id': ?0 } }",
            "{ $project: { '_id': 1, 'user_id': 1,'loan_date': 1, 'due_date': '$books_loan.due_date', 'book_id': '$booksloan._id', 'book_satus': '$books_loan.book_satus',title: '$booksloan.title' } }"
    })
    List<ViewLoanModel> findByUserId(String userid, ArrayList<String> status);

    @Aggregation(pipeline = {
            "{ $unwind: '$books_loan' }",
            "{ $match: { 'books_loan.book_id': { $ref: 'book', $id: ObjectId(?0) }, 'books_loan.book_satus': { $in: ['RESERVADO', 'PRESTADO', 'RENOVADO'] } } }",
            "{ $group: { '_id': '$books_loan.book_id', 'actives': { $sum: 1 } } }"
    })
    Optional<Integer> countActivesLoansForBookId(String bookId);

    @Aggregation(pipeline = {
            "{ $unwind: '$books_loan' }",
            "{ $match: { 'user_id': ?0, 'books_loan.book_satus': { $in: ['RESERVADO', 'PRESTADO', 'RENOVADO'] } } }",
            "{ $count: 'actives' }"
    })
    Optional<Integer> countActivesLoansForUserId(String userid);
}
