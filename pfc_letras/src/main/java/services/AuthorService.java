package services;

import models.Author;
import java.util.List;
import java.util.Optional;


public interface AuthorService {

    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(String id);

    Author addAuthor(Author author);
}
