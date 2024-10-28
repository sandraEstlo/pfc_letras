package com.letras.pfc_letras.services.loans;

public interface CheckAvailabilityLoanService {

    void isUserAvailableForLoan(String UserId, int numberOfBooksToRequest);

    void isBookAvailableForLoan(String BookId, int numberOfCopies);
}
