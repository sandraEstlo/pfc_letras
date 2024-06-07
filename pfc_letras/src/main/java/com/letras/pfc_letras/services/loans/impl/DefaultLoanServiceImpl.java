package com.letras.pfc_letras.services.loans.impl;

import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.models.LoanModels.ViewLoanModel;
import com.letras.pfc_letras.repositories.BookRepository;
import com.letras.pfc_letras.repositories.LoanRepository;
import com.letras.pfc_letras.services.loans.CheckAvailabilityLoanService;
import com.letras.pfc_letras.services.loans.LoanService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
    public List<ViewLoanModel> findByUserId(String status, String userId) {
        return loanRepository.findByUserId(status, userId);
    }
}
