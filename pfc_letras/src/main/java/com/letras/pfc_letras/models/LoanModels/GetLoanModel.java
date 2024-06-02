package com.letras.pfc_letras.models.LoanModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.letras.pfc_letras.models.UsersModels.UserModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class GetLoanModel {

    @Id
    private String id;

    @Field("user_id")
    @DBRef(lazy = true)
    @DocumentReference(lookup = "{ '_id': ?#{#target} }")
    private UserModel user;

    @Field("loan_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime loanDate;

    @Field("due_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dueDate;

    @Field("books_loan")
    private List<BookLoanModel> bookLoan;

}
