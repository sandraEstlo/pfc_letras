package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.CategoriesModels.CategoryModel;
import com.letras.pfc_letras.models.CategoriesModels.SubcategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryModel, String> {

//    List<SubcategoryModel> findSubCategoriesByCategoryId(String categoryId);

    Optional<SubcategoryModel> findBySpecificCategoriesContaining(String subcategoryId);
}
