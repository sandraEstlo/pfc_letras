package com.letras.pfc_letras.dtos.book;

import com.letras.pfc_letras.dtos.author.AuthorDto;
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
public class BookDetailsDto {

    private String id;

    private String title;

    private List<AuthorDto> authorsDto;

    private String description;

    private Date publishDate;

    private String image;

    private String category;

    private int copies;

    private String isbn;

    private String label;
}
