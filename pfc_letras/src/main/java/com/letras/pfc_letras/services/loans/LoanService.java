package com.letras.pfc_letras.services.loans;

import com.letras.pfc_letras.models.loans.LoanModel;
import com.letras.pfc_letras.models.loans.ViewLoanModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface LoanService {

    Optional<LoanModel> create(LoanModel loanModel);

    List<ViewLoanModel> findByUserId(String userId, ArrayList<String> status);

    Optional<LoanModel> renewLoan(String idLoan, String idBook);

    LoanModel renovateLoan(String userId, String bookId, String loanId);
}
