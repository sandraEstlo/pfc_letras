package com.letras.pfc_letras.facades.impl;

import com.letras.pfc_letras.converters.author.ConvertToAuthorDetailsDto;
import com.letras.pfc_letras.converters.author.ConvertToAuthorDto;
import com.letras.pfc_letras.converters.author.ConvertToAuthorModel;
import com.letras.pfc_letras.converters.book.ConvertToBookDetailsDto;
import com.letras.pfc_letras.converters.book.ConvertToBookDto;
import com.letras.pfc_letras.converters.user.ConvertToGetUserDto;
import com.letras.pfc_letras.converters.user.ConvertToUserModel;
import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.dtos.author.AuthorDto;
import com.letras.pfc_letras.dtos.book.BookDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.dtos.user.CreateUserDto;
import com.letras.pfc_letras.dtos.user.GetUserDto;
import com.letras.pfc_letras.errors.exceptions.NewUserWithDifferentPassword;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.UsersModels.UserModel;
import com.letras.pfc_letras.services.AuthorService;
import com.letras.pfc_letras.services.BookSearchService;
import com.letras.pfc_letras.services.BookService;
import com.letras.pfc_letras.services.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.List;
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
            throw new NewUserWithDifferentPassword();

        return userService.saveUser(convertToUserModel.convert(createUserDto));
    }

    @Override
    public Optional<GetUserDto> getUserDto(UserDetails userDetails) {
        return Optional.ofNullable(convertToGetUserDto.convert(userDetails));
    }
}
