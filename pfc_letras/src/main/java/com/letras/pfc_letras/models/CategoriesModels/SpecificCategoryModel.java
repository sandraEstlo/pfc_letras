package com.letras.pfc_letras.models.CategoriesModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document
public class SpecificCategoryModel {

    @Id
    private String id;

    private String name;

    private List<SubcategoryModel> subcategories;
}
