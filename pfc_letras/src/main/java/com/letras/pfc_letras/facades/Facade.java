package com.letras.pfc_letras.facades;

import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.dtos.author.AuthorDto;
import com.letras.pfc_letras.dtos.book.BookDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.dtos.loan.CreateUpdateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.dtos.loan.ViewLoanDto;
import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.dtos.user.GetUserDto;
import com.letras.pfc_letras.models.UsersModels.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Facade {

    List<BookDto> findAllBooks();

    Optional<BookDetailsDto> findBookById(String idBook);

    List<BookDto> findByCategories(String ... paths);

    List<BookDto> searchBookByKey(String text);

    Optional<AuthorDetailsDto> findAuthorById(String idAuthor);

    Optional<AuthorDto> newAuthor(AuthorDto authorDto);

    Optional<UserModel> newUser(CreateUserDto createUserDto);

    Optional<GetUserDto> getUserDto(UserModel userModel);

    Optional<CreateUpdateLoanDto> newLoan(CreateLoanRequestDto createLoanRequestDto);

    Optional<CreateUpdateLoanDto> renewLoan(ViewLoanDto viewLoanDto);

    List<ViewLoanDto> getLoansById(String idUser, ArrayList<String> status);

    Optional<CreateUpdateLoanDto> renovateLoan(CreateLoanRequestDto createLoanRequestDto);
}
