package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.errors.exceptions.User.UserNotFound;
import com.letras.pfc_letras.errors.exceptions.loans.ErrorToCreateLoan;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.UsersModels.UserModel;
import com.letras.pfc_letras.models.UsersModels.UserRoles;
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

@Controller
@RequestMapping("/letras")
public class LoanController {

    @Resource
    private Facade facade;

    @GetMapping("/loan/user/{option}")
    public String viewLoans(Model model,
                            HttpSession session,
                            @PathVariable String option) {

        UserModel userModel = (UserModel) session.getAttribute("usersession");
        if (userModel != null && userModel.getRoles().contains(UserRoles.USER)) {
            model.addAttribute("user", facade.getUserDto(userModel).orElseThrow(UserNotFound::new));
            model.addAttribute("loans", facade.getLoansById(option, userModel.getId()));

            return "loans-user";
        }
        return "index";
    }

    @PutMapping("/new")
    public ResponseEntity<CreateLoanDto> addNewBookingLoan(@RequestBody CreateLoanRequestDto createLoanRequestDto) {
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(facade.newLoan(createLoanRequestDto).orElseThrow(ErrorToCreateLoan::new));
    }
}
