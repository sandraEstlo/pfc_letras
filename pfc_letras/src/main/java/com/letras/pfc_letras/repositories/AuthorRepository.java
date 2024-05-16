package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.AuthorModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends MongoRepository<AuthorModel, String> {

    List<AuthorModel> findByNameContainingIgnoreCase(String name);

    Optional<AuthorModel> findByName(String name);
}
