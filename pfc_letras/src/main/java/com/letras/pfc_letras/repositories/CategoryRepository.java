package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryModel, String> {

}
