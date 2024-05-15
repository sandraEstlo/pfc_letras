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
    private AuthorRepository authorRepository;

    @Override
    public List<AuthorModel> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<AuthorModel> findAuthorById(String id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<AuthorModel> findAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public List<AuthorModel> findAuthorByNameContaining(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public AuthorModel save(AuthorModel author) {
        return authorRepository.save(author);
    }
}
