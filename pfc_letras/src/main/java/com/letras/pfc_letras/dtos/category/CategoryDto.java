package com.letras.pfc_letras.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryDto {

    private String id;

    private String classGroup;

    private String name;

    private String path;

    private List<CategoryDto> subcategories;

}
