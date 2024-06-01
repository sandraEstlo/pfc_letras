package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.models.LoanModels.BookLoanModel;
import com.letras.pfc_letras.models.LoanModels.EnumState;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.repositories.LoanRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class ApiLoanController {

    @Resource
    private LoanRepository loanRepository;

    @GetMapping("/all")
    public List<LoanModel> getAuthorsLoan() {
        return loanRepository.findAll();
    }

    @PutMapping("/new")
    public LoanModel addNewLoan(@RequestParam String idBook, String idUser) {
        LoanModel loanModel = LoanModel.builder().build();
        loanModel.setBookLoan(List.of(BookLoanModel.builder()
                                  .book(BookModel.builder().id(idBook).build())
                                  .bookStatus(EnumState.RESERVADO)
                                .build()));
        return loanRepository.save(loanModel);
    }
}
