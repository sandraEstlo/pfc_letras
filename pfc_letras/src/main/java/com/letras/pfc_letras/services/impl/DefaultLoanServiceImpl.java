package com.letras.pfc_letras.services.impl;

import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.repositories.LoanRepository;
import com.letras.pfc_letras.services.loans.LoanService;
import jakarta.annotation.Resource;

import java.util.Optional;
public class DefaultLoanServiceImpl implements LoanService {

    @Resource
    private LoanRepository loanRepository;

    @Override
    public Optional<LoanModel> save(LoanModel loanModel) {
        return Optional.of(loanRepository.save(loanModel));
    }
}
