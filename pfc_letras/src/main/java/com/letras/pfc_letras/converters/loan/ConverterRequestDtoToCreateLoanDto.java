package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.CreateBookLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.models.LoanModels.EnumState;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class ConverterRequestDtoToCreateLoanDto implements Converter<CreateLoanRequestDto, CreateLoanDto> {

    @Override
    public CreateLoanDto convert(CreateLoanRequestDto createLoanRequestDto) {

        final int PLUS_DAYS_LOAN = 60;
        final int PLUS_DAYS_BOOK = 3;

//        int plusDays = (createLoanRequestDto.getState().equals(EnumState.PRESTADO)) ? PLUS_DAYS_LOAN
//                                                                                    : PLUS_DAYS_BOOK;

        return CreateLoanDto.builder()
                            .userId(createLoanRequestDto.getUserId())
                            .loanDate(LocalDateTime.now())
                            .dueDate(LocalDateTime.now().plusDays(PLUS_DAYS_BOOK))
                            .booksLoan(createLoanRequestDto.getBookIds()
                                                           .stream()
                                                           .map(idBook ->
                                                                   CreateBookLoanDto
                                                                            .builder()
                                                                            .bookId(idBook)
                                                                            .status(EnumState.RESERVADO)
                                                                            .returnedDate(null)
                                                                            .build())
                                                           .collect(Collectors.toList()))

                            .build();
    }
}
