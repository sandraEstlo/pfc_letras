package com.letras.pfc_letras.services;

import com.letras.pfc_letras.models.CategoriesModels.SubcategoryModel;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public interface CategoryService{

    Optional<SubcategoryModel> findBySpecificCategoriesContaining(String subcategoryId);
}
