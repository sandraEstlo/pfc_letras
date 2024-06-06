package com.letras.pfc_letras.services.loans.impl;

import com.letras.pfc_letras.errors.exceptions.loans.BookNotAvailableException;
import com.letras.pfc_letras.errors.exceptions.loans.UserNotAvailableException;
import com.letras.pfc_letras.repositories.LoanRepository;
import com.letras.pfc_letras.services.loans.CheckAvailabilityLoanService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CheckAvailabilityLoanServiceImpl implements CheckAvailabilityLoanService {

    @Resource
    private LoanRepository loanRepository;


    @Override
    public void isUserAvailableForLoan(String UserId, int numberOfBooksToRequest) {
        int MAX_LOANS_FOR_USERS = 3;
        int activeLoans = loanRepository.countActivesLoansForUserId(UserId).orElse(0);

        if((activeLoans + numberOfBooksToRequest) > MAX_LOANS_FOR_USERS)
            throw new UserNotAvailableException();
    }

    @Override
    public void isBookAvailableForLoan(String BookId, int numberOfCopies) {
        int activeLoansForBook = loanRepository.countActivesLoansForBookId(BookId).orElse(0);

        if (activeLoansForBook >= numberOfCopies)
            throw new BookNotAvailableException();
    }
}
