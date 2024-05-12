package com.letras.pfc_letras.models.CategoriesModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SubcategoryModel {

    @Id
    private String id;

    private String name;
}
