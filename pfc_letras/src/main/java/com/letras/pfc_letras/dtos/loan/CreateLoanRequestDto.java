package com.letras.pfc_letras.dtos.loan;

import com.letras.pfc_letras.models.LoanModels.EnumState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLoanRequestDto {
    private String userId;
    private List<String> bookIds;
    private EnumState state;
}
