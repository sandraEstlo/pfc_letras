package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.converters.loan.ConvertToLoanModelCreate;
import com.letras.pfc_letras.converters.loan.ConverterRequestDtoToCreateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.repositories.LoanRepository;
import com.letras.pfc_letras.services.loans.LoanService;
import jakarta.annotation.Resource;
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

    @Resource
    private ConvertToLoanModelCreate convertToLoanModelCreate;

    @Resource
    private ConverterRequestDtoToCreateLoanDto converterRequestDtoToCreateLoanDto;

    @GetMapping("/all")
    public List<LoanModel> getAuthorsLoan() {
        return loanRepository.findAll();
    }

    @PutMapping("/new")
    public LoanModel addNewBookingLoan(@RequestBody CreateLoanRequestDto createLoanRequestDto) {
//        CreateLoanDto createLoanDto = converterRequestDtoToCreateLoanDto.convert(createLoanRequestDto);
//        assert createLoanDto != null;
//        return convertToLoanModelCreate.convert(createLoanDto);

        return facade.newLoan(createLoanRequestDto).get();
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
