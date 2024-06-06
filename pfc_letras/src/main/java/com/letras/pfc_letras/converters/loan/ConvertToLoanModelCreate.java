package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.repositories.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToLoanModelCreate implements Converter<CreateLoanDto, LoanModel> {

    @Resource
    public ConvertToBooksLoanCreate convertToBooksLoanCreate;

    @Override
    public LoanModel convert(CreateLoanDto createLoanDto) {

        return LoanModel.builder()
                        .userId(createLoanDto.getUserId())
                        .loanDate(createLoanDto.getLoanDate())
                        .dueDate(createLoanDto.getDueDate())
                        .bookLoan(createLoanDto.getBooksLoan()
                                               .stream()
                                               .map(convertToBooksLoanCreate::convert).toList())
                        .build();
    }
}
