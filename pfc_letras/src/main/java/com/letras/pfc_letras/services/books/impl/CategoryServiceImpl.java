package com.letras.pfc_letras.services.books.impl;

import com.letras.pfc_letras.models.CategoryModel;
import com.letras.pfc_letras.repositories.CategoryRepository;
import com.letras.pfc_letras.services.books.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryModel> AllCategories() {

        return categoryRepository.findAll();
    }
}
