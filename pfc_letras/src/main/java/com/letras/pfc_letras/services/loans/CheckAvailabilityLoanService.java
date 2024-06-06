package com.letras.pfc_letras.services.loans;

public interface CheckAvailabilityLoanService {

    public void isUserAvailableForLoan(String UserId, int numberOfBooksToRequest);

    public void isBookAvailableForLoan(String BookId, int numberOfCopies);
}
