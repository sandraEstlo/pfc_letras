package com.letras.pfc_letras.services;

import com.letras.pfc_letras.models.CategoryModel;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface CategoryService{

    public List<CategoryModel> AllCategories();
}
