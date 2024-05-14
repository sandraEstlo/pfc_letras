package com.letras.pfc_letras.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
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

    @DocumentReference(lookup = "{ '_id': ?#{#target} }")
    private List<AuthorModel> authors;

    private String description;

    @Field("publication_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date publishDate;

    @Field("subcategory_id")
    private String subcategoryId;

    private int copies;

    private String image;

    private String title;

    private String isbn;

    private String label;
}
