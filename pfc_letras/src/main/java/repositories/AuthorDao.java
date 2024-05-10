package repositories;

import models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends MongoRepository<Author, String> {

}
