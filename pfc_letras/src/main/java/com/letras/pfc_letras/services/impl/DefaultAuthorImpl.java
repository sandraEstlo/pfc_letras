package com.letras.pfc_letras.services.impl;

import com.letras.pfc_letras.services.AuthorService;
import jakarta.annotation.Resource;
import com.letras.pfc_letras.models.AuthorModel;
import org.springframework.stereotype.Service;
import com.letras.pfc_letras.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultAuthorImpl implements AuthorService {

    @Resource
    private AuthorRepository authorDao;

    @Override
    public List<AuthorModel> findAllAuthors() {
        return authorDao.findAll();
    }

    @Override
    public Optional<AuthorModel> findAuthorById(String id) {
        return authorDao.findById(id);
    }

    @Override
    public Optional<AuthorModel> findAuthorByName(String name) {
        return authorDao.findByName(name);
    }

    @Override
    public List<AuthorModel> findAuthorByNameContaining(String name) {
        return authorDao.findByNameContainingIgnoreCase(name);
    }

    @Override
    public AuthorModel save(AuthorModel author) {
        return authorDao.save(author);
    }
}
