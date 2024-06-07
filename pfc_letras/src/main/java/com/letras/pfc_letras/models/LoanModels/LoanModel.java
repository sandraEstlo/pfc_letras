package com.letras.pfc_letras.models.LoanModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.letras.pfc_letras.models.UsersModels.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "loan")
public class LoanModel {

    @Id
    private String id;

    @Field("user_id")
    private String userId;

    @Field("loan_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime loanDate;

//    @Field("due_date")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDateTime dueDate;

    @Field("books_loan")
    private List<BookLoanModel> bookLoan;
}
