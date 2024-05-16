package com.letras.pfc_letras.services.impl;

import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.repositories.BookRepository;
import com.letras.pfc_letras.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBookImpl implements BookService {

    @Resource
    private BookRepository bookRepository;


    @Override
    public List<BookModel> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<BookModel> findByCategories(String ... paths) {
        return bookRepository.findByCategories(paths);
    }

    @Override
    public List<BookModel> findByAuthorNameContainingIgnoreCase(String authorName) {
        return bookRepository.findByAuthorsNameContainingIgnoreCase(authorName);
    }

    @Override
    public List<BookModel> findByAuthorsContaining(String idAuthor) {
        return bookRepository.findByAuthorsContaining(idAuthor);
    }

}
