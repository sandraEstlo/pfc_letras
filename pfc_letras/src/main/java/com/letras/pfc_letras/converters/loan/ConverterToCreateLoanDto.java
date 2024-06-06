package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import jakarta.annotation.Resource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConverterToCreateLoanDto implements Converter<LoanModel, CreateLoanDto> {

    @Resource
    private ConverterToBooksLoanCreateDto converterToBooksLoanCreateDto;

    @Override
    public CreateLoanDto convert(LoanModel loanModel) {

        return CreateLoanDto.builder()
                            .userId(loanModel.getUserId())
                            .loanDate(loanModel.getLoanDate())
                            .dueDate(loanModel.getDueDate())
                            .booksLoan(loanModel.getBookLoan()
                                                .stream()
                                                .map(converterToBooksLoanCreateDto::convert).collect(Collectors.toList()))
                            .build();
    }
}
