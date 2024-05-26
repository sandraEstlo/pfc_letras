package com.letras.pfc_letras.dtos.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookDto {

    private String id;

    private String title;

    private String authorsNames;

    private String image;

    private String category;
}
