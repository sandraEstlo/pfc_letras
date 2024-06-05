package com.letras.pfc_letras.models.LoanModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
public class GetLoanModel {

    @Id
    private String id;

    private LocalDateTime loanDate;

    private LocalDate dueDate;

    private String bookId;

    private String bookStatus;
}
