package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.CreateUpdateLoanDto;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import jakarta.annotation.Resource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToLoanModelCreate implements Converter<CreateUpdateLoanDto, LoanModel> {

    @Resource
    public ConvertToBooksLoanCreate convertToBooksLoanCreate;

    @Override
    public LoanModel convert(CreateUpdateLoanDto createLoanDto) {

        return LoanModel.builder()
                        .userId(createLoanDto.getUserId())
                        .loanDate(createLoanDto.getLoanDate())
                        .bookLoan(createLoanDto.getBooksLoan()
                                               .stream()
                                               .map(convertToBooksLoanCreate::convert).toList())
                        .build();
    }
}
