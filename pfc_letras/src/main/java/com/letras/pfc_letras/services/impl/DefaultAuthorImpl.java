package com.letras.pfc_letras.services.impl;

import com.letras.pfc_letras.services.AuthorService;
import jakarta.annotation.Resource;
import com.letras.pfc_letras.models.Author;
import org.springframework.stereotype.Service;
import com.letras.pfc_letras.repositories.AuthorDao;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultAuthorImpl implements AuthorService {

    @Resource
    private AuthorDao authorDao;

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(String id) {
        return authorDao.findById(id);
    }

    @Override
    public Author addAuthor(Author author) {
        return authorDao.save(author);
    }
}