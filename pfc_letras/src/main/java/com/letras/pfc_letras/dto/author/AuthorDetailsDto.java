package com.letras.pfc_letras.dto.author;

import com.letras.pfc_letras.dto.book.BookDto;
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
public class AuthorDetailsDto {

    private String id;

    private String name;

    private String description;

    private List<BookDto> booksDto;
}
