package com.letras.pfc_letras.services.loans;

public interface CheckAvailabilityLoanService {

    public boolean isUserAvailableForLoan(String UserId, int numberOfBooksToRequest);

    public boolean isBookAvailableForLoan(String BookId, int numberOfCopies);
}
