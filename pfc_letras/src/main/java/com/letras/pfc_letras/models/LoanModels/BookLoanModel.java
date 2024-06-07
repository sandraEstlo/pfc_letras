package com.letras.pfc_letras.models.LoanModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.letras.pfc_letras.models.BookModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter @Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookLoanModel {

    @Field("book_id")
    @DBRef(lazy = true)
    private BookModel book;

    @Field("book_satus")
    private EnumState bookStatus;

    @Field("due_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime returnedDate;
}
