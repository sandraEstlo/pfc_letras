package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.errors.exceptions.loans.ErrorToCreateLoan;
import com.letras.pfc_letras.facades.Facade;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
//@RequestMapping("/letras")
public class LoanController {

    @Resource
    private Facade facade;


    @PutMapping("/new")
    public ResponseEntity<CreateLoanDto> addNewBookingLoan(@RequestBody CreateLoanRequestDto createLoanRequestDto) {
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(facade.newLoan(createLoanRequestDto).orElseThrow(ErrorToCreateLoan::new));
    }
}
