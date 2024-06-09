package com.letras.pfc_letras.facades.impl;

import com.letras.pfc_letras.converters.author.ConvertToAuthorDetailsDto;
import com.letras.pfc_letras.converters.author.ConvertToAuthorDto;
import com.letras.pfc_letras.converters.author.ConvertToAuthorModel;
import com.letras.pfc_letras.converters.book.ConvertToBookDetailsDto;
import com.letras.pfc_letras.converters.book.ConvertToBookDto;
import com.letras.pfc_letras.converters.loan.ConvertToLoanModelCreate;
import com.letras.pfc_letras.converters.loan.ConverterRequestDtoToCreateLoanDto;
import com.letras.pfc_letras.converters.loan.ConverterToCreateLoanDto;
import com.letras.pfc_letras.converters.loan.ConverterToViewLoansDto;
import com.letras.pfc_letras.converters.user.ConvertToGetUserDto;
import com.letras.pfc_letras.converters.user.ConvertToUserModel;
import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.dtos.author.AuthorDto;
import com.letras.pfc_letras.dtos.book.BookDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.dtos.loan.CreateUpdateLoanDto;
import com.letras.pfc_letras.dtos.loan.CreateLoanRequestDto;
import com.letras.pfc_letras.dtos.loan.ViewLoanDto;
import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.dtos.user.GetUserDto;
import com.letras.pfc_letras.errors.exceptions.User.NewUserWithDifferentPassword;
import com.letras.pfc_letras.errors.exceptions.loans.ErrorToConverterModel;
import com.letras.pfc_letras.errors.exceptions.loans.ErrorToCreateLoan;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.LoanModels.LoanModel;
import com.letras.pfc_letras.models.UsersModels.UserModel;
import com.letras.pfc_letras.services.authors.AuthorService;
import com.letras.pfc_letras.services.books.BookSearchService;
import com.letras.pfc_letras.services.books.BookService;
import com.letras.pfc_letras.services.users.UserService;
import com.letras.pfc_letras.services.loans.LoanService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DefaultFacade implements Facade {

    @Resource
    private BookService bookService;

    @Resource
    private BookSearchService bookSearchService;

    @Resource
    private AuthorService authorService;

    @Resource
    private UserService userService;

    @Resource
    private LoanService loanService;

    @Resource
    private ConvertToAuthorDetailsDto convertToAuthorDetailsDto;

    @Resource
    private ConvertToBookDto convertToBookDto;

    @Resource
    private ConvertToBookDetailsDto convertToBookDetailsDto;

    @Resource
    private ConvertToAuthorDto convertToAuthorDto;

    @Resource
    private ConvertToAuthorModel convertToAuthorModel;

    @Resource
    private ConvertToUserModel convertToUserModel;

    @Resource
    private ConvertToGetUserDto convertToGetUserDto;

    @Resource
    private ConvertToLoanModelCreate convertToLoanModelCreate;

    @Resource
    private ConverterRequestDtoToCreateLoanDto converterRequestDtoToCreateLoanDto;

    @Resource
    private ConverterToCreateLoanDto converterToCreateLoanDto;

    @Resource
    private ConverterToViewLoansDto converterToViewLoansDto;

    @Override
    public List<BookDto> findAllBooks() {
        return bookService.findAllBooks()
                          .stream()
                          .map(convertToBookDto::convert).collect(Collectors.toList());
    }
    @Override
    public Optional<BookDetailsDto> findBookById(String idBook) {
        return bookService.findById(idBook).map(convertToBookDetailsDto::convert);
    }

    @Override
    public List<BookDto> findByCategories(String... paths) {
        return bookService.findByCategories(paths)
                          .stream()
                          .map(convertToBookDto::convert).collect(Collectors.toList());
    }
    @Override
    public List<BookDto> searchBookByKey(String text) {
        return bookSearchService.KeywordsSearch(text)
                                .stream()
                                .map(convertToBookDto::convert).collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorDetailsDto> findAuthorById(String idAuthor) {
        return authorService.findAuthorById(idAuthor)
                            .map(convertToAuthorDetailsDto::convert);
    }

    @Override
    public Optional<AuthorDto> newAuthor(AuthorDto authorDto) {
        return Optional.ofNullable(convertToAuthorDto.convert(authorService.save(convertToAuthorModel.convert(authorDto))));
    }

    @Override
    public Optional<UserModel> newUser(CreateUserDto createUserDto) {
        if (!createUserDto.getPassword().equals(createUserDto.getConfirmPassword()))
            throw new NewUserWithDifferentPassword(createUserDto);

        return userService.saveUser(convertToUserModel.convert(createUserDto));
    }

    @Override
    public Optional<GetUserDto> getUserDto(UserModel userModel) {
        return Optional.ofNullable(convertToGetUserDto.convert(userModel));
    }

    @Override
    public Optional<CreateUpdateLoanDto> newLoan(CreateLoanRequestDto createLoanRequestDto) {
        LoanModel newLoanModel = Optional.of(Objects.requireNonNull
                                            (
                                                convertToLoanModelCreate.convert(Objects.requireNonNull(
                                                converterRequestDtoToCreateLoanDto.convert(createLoanRequestDto))))
                                             ).orElseThrow(ErrorToConverterModel::new);
        return Optional.ofNullable(
                converterToCreateLoanDto.convert(loanService.create(newLoanModel).orElseThrow(ErrorToCreateLoan::new)));
    }

    @Override
    public Optional<CreateUpdateLoanDto> renewLoan(ViewLoanDto viewLoanDto) {

        return Optional.ofNullable(converterToCreateLoanDto
                                    .convert(loanService.renewLoan(viewLoanDto.getId(), viewLoanDto.getBookId())
                                    .orElseThrow(() -> new ErrorToCreateLoan("Ha ocurrido un error al crear el prestamo."))));
    }

    @Override
    public Optional<CreateUpdateLoanDto> renovateLoan(CreateLoanRequestDto createLoanRequestDto) {
        return Optional.ofNullable(converterToCreateLoanDto.convert(loanService.renovateLoan(
                                                                        createLoanRequestDto.getUserId(),
                                                                        createLoanRequestDto.getBookIds().get(0),
                                                                        createLoanRequestDto.getLoanId())
                                                                    ));
    }

    @Override
    public List<ViewLoanDto> getLoansById(String idUser, ArrayList<String> status) {
        return loanService.findByUserId(idUser, status).stream()
                                                       .map(converterToViewLoansDto::convert).collect(Collectors.toList());
    }
}
