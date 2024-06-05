package com.letras.pfc_letras.services.loans;

import com.letras.pfc_letras.models.LoanModels.LoanModel;
import java.util.Optional;

public interface LoanService {

    Optional<LoanModel> save(LoanModel loanModel);
}
