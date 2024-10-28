package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.loan.CreateUpdateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.errors.exceptions.User.UserNotFound;
import com.letras.pfc_letras.errors.exceptions.loans.ErrorToCreateLoan;
import com.letras.pfc_letras.errors.exceptions.loans.ErrorToUpdateLoan;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.users.UserModel;
import com.letras.pfc_letras.models.users.UserRoles;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/letras")
public class LoanController {

    @Resource
    private Facade facade;

    @GetMapping("/loan/user/{options}")
    public String viewLoans(Model model,
                            HttpSession session,
                            @PathVariable String options) {

        UserModel userModel = (UserModel) session.getAttribute("usersession");
        if (userModel != null && userModel.getRoles().contains(UserRoles.USER)) {
            ArrayList<String> optionsList = new ArrayList<>(Arrays.asList(options.split(",")));
            model.addAttribute("user", facade.getUserDto(userModel).orElseThrow(UserNotFound::new));
            model.addAttribute("loans", facade.getLoansById(userModel.getId(), optionsList));

            return "loans-user";
        }
        return "index";
    }

    @PutMapping("/new")
    public ResponseEntity<CreateUpdateLoanDto> addNewBookingLoan(@RequestBody CreateLoanRequestDto createLoanRequestDto) {
        return  ResponseEntity.status(HttpStatus.CREATED)
                              .body(facade.newLoan(createLoanRequestDto).orElseThrow(ErrorToCreateLoan::new));
    }

    @PutMapping("/renovate")
    public ResponseEntity<CreateUpdateLoanDto> renovateLoan(@RequestBody CreateLoanRequestDto createLoanRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(facade.renovateLoan(createLoanRequestDto).orElseThrow(ErrorToUpdateLoan::new));
    }
}
