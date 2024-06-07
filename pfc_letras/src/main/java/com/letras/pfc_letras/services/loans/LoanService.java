package com.letras.pfc_letras.services.loans;

import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.models.LoanModels.ViewLoanModel;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    Optional<LoanModel> create(LoanModel loanModel);

    List<ViewLoanModel> findByUserId(String status, String userId);
}
