package com.letras.pfc_letras.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Document("category")
public class CategoryModel {

    @Id
    private String id;

    private String name;

    private String path;

    private List<CategoryModel> subcategories;
}
