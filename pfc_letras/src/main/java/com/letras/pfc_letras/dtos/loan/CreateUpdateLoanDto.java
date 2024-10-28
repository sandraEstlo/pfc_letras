package com.letras.pfc_letras.dtos.loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateLoanDto {

    private String loanId;

    private String userId;

    @Builder.Default
    private LocalDateTime loanDate = LocalDateTime.now();

    private List<CreateBookLoanDto> booksLoan;
}
