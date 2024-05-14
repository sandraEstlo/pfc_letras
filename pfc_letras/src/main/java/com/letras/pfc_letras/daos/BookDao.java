package com.letras.pfc_letras.daos;

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
public class BookDao {

    private String id;

    private List<AuthorModel> authors;

    private int copies;

    private String description;

    private String image;

    private String isbn;

    private Date publishDate;

    private String subcategoryId;

    private String title;

    private String label;
}
