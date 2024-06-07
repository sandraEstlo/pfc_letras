package com.letras.pfc_letras.dtos.loan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ViewLoanDto {

    private String id;

    private String userId;

    private LocalDate loanDate;

    private LocalDate dueDate;

    private String bookId;

    private String bookStatus;

    private String title;

    private boolean renew;
}
