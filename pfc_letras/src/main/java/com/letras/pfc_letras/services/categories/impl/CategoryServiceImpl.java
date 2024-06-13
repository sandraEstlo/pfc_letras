package com.letras.pfc_letras.services.categories.impl;

import com.letras.pfc_letras.models.CategoryModel;
import com.letras.pfc_letras.repositories.CategoryRepository;
import com.letras.pfc_letras.services.categories.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryModel> getAllGroupCategories() {
        return categoryRepository.findAllUsingAggregation();
    }
}
