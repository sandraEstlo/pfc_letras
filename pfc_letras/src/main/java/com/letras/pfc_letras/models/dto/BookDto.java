package com.letras.pfc_letras.models.dto;

import com.letras.pfc_letras.models.AuthorModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookDto {

    private String id;

    private List<AuthorModel> authors;

    private String description;

    private int copies;

    private String image;

    private String isbn;

    private Date publishDate;

    private String category;

    private String title;

    private String label;
}
