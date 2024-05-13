package com.letras.pfc_letras.services.impl;
import com.letras.pfc_letras.models.CategoriesModels.SubcategoryModel;
import com.letras.pfc_letras.repositories.CategoryRepository;
import com.letras.pfc_letras.services.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public Optional<SubcategoryModel> findBySpecificCategoriesContaining(String subcategoryId) {

        return categoryRepository.findBySpecificCategoriesContaining(subcategoryId);
    }
}
