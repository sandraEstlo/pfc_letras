package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.CreateUpdateLoanDto;
import com.letras.pfc_letras.models.loans.LoanModel;
import jakarta.annotation.Resource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConverterToCreateLoanDto implements Converter<LoanModel, CreateUpdateLoanDto> {

    @Resource
    private ConverterToBooksLoanCreateDto converterToBooksLoanCreateDto;

    @Override
    public CreateUpdateLoanDto convert(LoanModel loanModel) {

        return CreateUpdateLoanDto.builder()
                            .userId(loanModel.getUserId())
                            .loanDate(loanModel.getLoanDate())
                            .booksLoan(loanModel.getBookLoan()
                                                .stream()
                                                .map(converterToBooksLoanCreateDto::convert).collect(Collectors.toList()))
                            .build();
    }
}
