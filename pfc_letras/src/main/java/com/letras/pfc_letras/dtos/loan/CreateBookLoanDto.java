package com.letras.pfc_letras.dtos.loan;

import com.letras.pfc_letras.models.LoanModels.EnumState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookLoanDto {

    private String bookId;
    private EnumState status;
    private LocalDateTime returnedDate;
}
