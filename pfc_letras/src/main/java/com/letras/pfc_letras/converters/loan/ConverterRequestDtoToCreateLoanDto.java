package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.CreateBookLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.models.LoanModels.EnumState;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ConverterRequestDtoToCreateLoanDto implements Converter<CreateLoanRequestDto, CreateLoanDto> {

    @Override
    public CreateLoanDto convert(CreateLoanRequestDto createLoanRequestDto) {

        EnumState enumState = (createLoanRequestDto.getOperation().equals("PRESTAR") ? EnumState.PRESTADO : EnumState.RESERVADO);

        final int PLUS_DAYS_LOAN = 60;
        final int PLUS_DAYS_BOOK = 3;

        int plusDays = (Objects.equals(enumState,EnumState.PRESTADO)) ? PLUS_DAYS_LOAN : PLUS_DAYS_BOOK;

        return CreateLoanDto.builder()
                            .userId(createLoanRequestDto.getUserId())
                            .loanDate(LocalDateTime.now())
                            .dueDate(LocalDateTime.now().plusDays(plusDays))
                            .booksLoan(createLoanRequestDto.getBookIds()
                                                           .stream().map(idBook -> CreateBookLoanDto
                                                                                    .builder()
                                                                                    .bookId(idBook)
                                                                                    .status(enumState)
                                                                                    .returnedDate(null)
                                                                                    .build())
                                                           .collect(Collectors.toList()))

                            .build();
    }
}
