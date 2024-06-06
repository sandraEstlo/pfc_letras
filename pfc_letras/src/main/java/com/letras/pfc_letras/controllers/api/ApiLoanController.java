package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.errors.exceptions.loans.ErrorToCreateLoan;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.repositories.LoanRepository;
import com.letras.pfc_letras.services.loans.LoanService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class ApiLoanController {

    @Resource
    private LoanRepository loanRepository;

    @Resource
    private LoanService loanService;

    @Resource
    private Facade facade;

    @GetMapping("/all")
    public List<LoanModel> getAuthorsLoan() {
        return loanRepository.findAll();
    }

    @PutMapping("/new")
    public ResponseEntity<CreateLoanDto> addNewBookingLoan(@RequestBody CreateLoanRequestDto createLoanRequestDto) {
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(facade.newLoan(createLoanRequestDto).orElseThrow(ErrorToCreateLoan::new));
    }

    @GetMapping("/countBook")
    public int getCountBookLoan() {
        return loanRepository.countActivesLoansForBookId("66412245170c9500f26e1049").orElse(0);
    }

    @GetMapping("/countUser")
    public int getCountUserId() {
        return loanRepository.countActivesLoansForUserId("665b53c34e5fe0e78d03739f").orElse(0);
    }
}
