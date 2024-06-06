package com.letras.pfc_letras.services.loans.impl;

import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.repositories.LoanRepository;
import com.letras.pfc_letras.services.loans.CheckAvailabilityLoanService;
import com.letras.pfc_letras.services.loans.LoanService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DefaultLoanServiceImpl implements LoanService {

    @Resource
    private LoanRepository loanRepository;

    @Resource
    private CheckAvailabilityLoanService checkAvailabilityLoanService;

    @Override
    public Optional<LoanModel> save(LoanModel loanModel) {

        checkAvailabilityLoanService.isUserAvailableForLoan(loanModel.getUserId(), loanModel.getBookLoan().size());
        checkAvailabilityLoanService.isBookAvailableForLoan(loanModel.getBookLoan().get(0).getBook().getId(),loanModel.getBookLoan().get(0).getBook().getCopies());
        return Optional.of(loanRepository.save(loanModel));
    }
}
