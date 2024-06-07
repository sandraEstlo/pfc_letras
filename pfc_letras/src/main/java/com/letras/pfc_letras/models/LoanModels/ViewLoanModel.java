package com.letras.pfc_letras.models.LoanModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ViewLoanModel {

    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("loan_date")
    private LocalDateTime loanDate;

    @Field("due_date")
    private LocalDate dueDate;

    @Field("book_id")
    private String bookId;

    @Field("book_satus")
    private String bookStatus;
}
