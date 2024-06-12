package com.letras.pfc_letras.converters.loan;

import com.letras.pfc_letras.dtos.loan.ViewLoanDto;
import com.letras.pfc_letras.models.loans.EnumState;
import com.letras.pfc_letras.models.loans.ViewLoanModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConverterToViewLoansDto implements Converter<ViewLoanModel, ViewLoanDto> {

    @Override
    public ViewLoanDto convert(ViewLoanModel viewLoanModel) {
        boolean isRenew = viewLoanModel.getBookStatus().equalsIgnoreCase(EnumState.PRESTADO.toString())
                          && viewLoanModel.getDueDate().isAfter(LocalDate.now())
                          && viewLoanModel.getDueDate().isBefore(LocalDate.now().plusDays(4));

        return ViewLoanDto.builder()
                          .id(viewLoanModel.getId())
                          .userId(viewLoanModel.getUserId())
                          .loanDate(viewLoanModel.getLoanDate())
                          .dueDate(viewLoanModel.getDueDate())
                          .bookId(viewLoanModel.getBookId())
                          .bookStatus(viewLoanModel.getBookStatus())
                          .title(viewLoanModel.getTitle())
                          .renew((isRenew))
                          .build();
    }
}
