package com.letras.pfc_letras.models;

import com.letras.pfc_letras.models.CategoriesModels.SubcategoryModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "book")
public class BookModel {

    @Id
    private String id;

    @DBRef
    private List<AuthorModel> authors;

    private int copies;

    private String description;

    private String image;

    private String isbn;

    @DateTimeFormat
    private Date publishDate;

    @DBRef
    private SubcategoryModel subcategory;

    private String title;

    private String label;
}
