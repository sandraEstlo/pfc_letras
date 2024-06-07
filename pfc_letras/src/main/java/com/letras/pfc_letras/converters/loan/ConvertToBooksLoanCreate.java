package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.CreateBookLoanDto;
import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.models.LoanModels.BookLoanModel;
import com.letras.pfc_letras.models.LoanModels.EnumState;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToBooksLoanCreate implements Converter<CreateBookLoanDto, BookLoanModel> {

    @Override
    public BookLoanModel convert(CreateBookLoanDto createBookLoanDto) {

        return BookLoanModel.builder()
                            .book(BookModel.builder().id(createBookLoanDto.getBookId()).build())
                            .bookStatus(createBookLoanDto.getStatus())
                            .returnedDate(createBookLoanDto.getDueDate())
                            .build();
    }
}
