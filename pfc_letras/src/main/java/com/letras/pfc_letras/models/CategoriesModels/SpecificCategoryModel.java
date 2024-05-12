package com.letras.pfc_letras.models.CategoriesModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class SpecificCategoryModel {

    @Id
    private String id;

    private String name;

    private List<SubcategoryModel> subcategories;
}
