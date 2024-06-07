package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.CreateBookLoanDto;
import com.letras.pfc_letras.models.LoanModels.BookLoanModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConverterToBooksLoanCreateDto implements Converter<BookLoanModel, CreateBookLoanDto> {

    @Override
    public CreateBookLoanDto convert(BookLoanModel bookLoanModel) {

        return CreateBookLoanDto.builder()
                .bookId(bookLoanModel.getBook().getId())
                .status(bookLoanModel.getBookStatus())
                .dueDate(bookLoanModel.getReturnedDate())
                .build();
    }
}
