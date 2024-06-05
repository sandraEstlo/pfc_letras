package com.letras.pfc_letras.services.impl;

import com.letras.pfc_letras.repositories.LoanRepository;
import com.letras.pfc_letras.services.loans.CheckAvailabilityLoanService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CheckAvailabilityLoanServiceImpl implements CheckAvailabilityLoanService {

    @Resource
    private LoanRepository loanRepository;

    @Override
    public boolean isUserAvailableForLoan(String UserId, int numberOfBooksToRequest) {
        int MAX_LOANS_FOR_USERS = 3;

        return loanRepository.countActivesLoansForUserId(UserId) + numberOfBooksToRequest < MAX_LOANS_FOR_USERS;
    }

    @Override
    public boolean isBookAvailableForLoan(String BookId, int numberOfCopies) {

        return loanRepository.countActivesLoansForBookId(BookId) < numberOfCopies;
    }
}
