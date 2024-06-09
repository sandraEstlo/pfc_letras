package com.letras.pfc_letras.services.loans.impl;

import com.letras.pfc_letras.errors.exceptions.loans.ErrorToUpdateLoan;
import com.letras.pfc_letras.errors.exceptions.loans.NotFoundLoan;
import com.letras.pfc_letras.models.LoanModels.EnumState;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.models.LoanModels.ViewLoanModel;
import com.letras.pfc_letras.repositories.BookRepository;
import com.letras.pfc_letras.repositories.LoanRepository;
import com.letras.pfc_letras.services.loans.CheckAvailabilityLoanService;
import com.letras.pfc_letras.services.loans.LoanService;
import jakarta.annotation.Resource;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultLoanServiceImpl implements LoanService {

    @Resource
    private LoanRepository loanRepository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private CheckAvailabilityLoanService checkAvailabilityLoanService;

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<LoanModel> create(LoanModel loanModel) {
        checkAvailabilityLoanService.isUserAvailableForLoan(loanModel.getUserId(), loanModel.getBookLoan().size());

        loanModel.getBookLoan().forEach(loanBook -> {
            checkAvailabilityLoanService.isBookAvailableForLoan(
                    loanBook.getBook().getId(),
                    bookRepository.returnCopiesFromBookId(loanBook.getBook().getId()).orElse(0)
            );
        });

        return Optional.of(loanRepository.save(loanModel));
    }
    @Override
    public List<ViewLoanModel> findByUserId(String userId, ArrayList<String> status) {
        return loanRepository.findByUserId(userId, status);
    }

    @Override
    public Optional<LoanModel> renewLoan(String idLoan, String idBook) {
        final int PLUS_DAYS = 60;

        LoanModel loanModel = loanRepository.findById(idLoan).orElseThrow(NotFoundLoan::new);
        loanModel.getBookLoan()
                 .stream()
                 .filter(loanBook -> loanBook.getBook().getId().equals(idBook))
                                             .findFirst()
                                             .ifPresent(loanBook ->
                                                        loanBook.setReturnedDate(LocalDateTime.now().plusDays(PLUS_DAYS)));
        return Optional.of(loanModel);
    }

    @Override
    public LoanModel renovateLoan(String userId, String bookId, String loanId) {
        Query query = new Query(Criteria.where("_id").is(loanId)
                .and("user_id").is(userId)
                .and("books_loan.book_id.$id").is(new ObjectId(bookId))
                .and("books_loan.book_satus").is(EnumState.PRESTADO.toString()));

        Update update = new Update();
        update.set("books_loan.$.due_date", LocalDate.now().plusDays(60));
        update.set("books_loan.$.book_satus", EnumState.RENOVADO.toString());

        return mongoTemplate.findAndModify(query, update, LoanModel.class);
    }
}
