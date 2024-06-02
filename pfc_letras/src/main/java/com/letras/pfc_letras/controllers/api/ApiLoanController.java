package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.converters.loan.ConvertToBooksLoanCreate;
import com.letras.pfc_letras.converters.loan.ConvertToLoanModelCreate;
import com.letras.pfc_letras.dtos.loan.CreateBookLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.models.LoanModels.BookLoanModel;
import com.letras.pfc_letras.models.LoanModels.EnumState;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.repositories.BookRepository;
import com.letras.pfc_letras.repositories.LoanRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/loan")
public class ApiLoanController {

    @Resource
    private LoanRepository loanRepository;

    @Resource
    private ConvertToLoanModelCreate convertToLoanModelCreate;

    @GetMapping("/all")
    public List<LoanModel> getAuthorsLoan() {
        return loanRepository.findAll();
    }

    @PutMapping("/new")
    public LoanModel addNewBookingLoan(@RequestParam String idBook, String idUser) {
        return loanRepository.save(Objects
                .requireNonNull(convertToLoanModelCreate.convert(CreateLoanDto
                        .builder()
                            .userId(idUser)
                                    .loanDate(LocalDateTime.now())
                                    .dueDate(LocalDateTime.now().plusDays(3))
                                    .booksLoan(List.of(CreateBookLoanDto.builder()
                                                                        .bookId(idBook)
                                                                        .status(EnumState.PRESTADO)
                                                                        .returnedDate(null)
                                                                        .build()))
                        .build())));
    }
}
