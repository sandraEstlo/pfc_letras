package services.impl;

import jakarta.annotation.Resource;
import models.Author;
import org.springframework.stereotype.Service;
import repositories.AuthorDao;
import services.AuthorService;

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
