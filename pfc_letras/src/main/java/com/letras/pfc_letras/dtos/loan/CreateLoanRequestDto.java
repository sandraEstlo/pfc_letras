package com.letras.pfc_letras.dtos.loan;

import com.letras.pfc_letras.models.LoanModels.EnumState;
import java.util.List;

public class CreateLoanRequestDto {
    private String UserId;
    private List<String> bookIds;
    private EnumState state;
}
