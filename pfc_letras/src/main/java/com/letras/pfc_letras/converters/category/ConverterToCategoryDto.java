package com.letras.pfc_letras.converters.category;

import com.letras.pfc_letras.dtos.category.CategoryDto;
import com.letras.pfc_letras.models.CategoryModel;
import jakarta.annotation.Resource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConverterToCategoryDto implements Converter<CategoryModel, CategoryDto> {

    @Override
    public CategoryDto convert(CategoryModel categoryModel) {

        return CategoryDto.builder()
                          .name(categoryModel.getName())
                          .subcategories(categoryModel.getSubcategories()
                                                      .stream()
                                                      .map(subcategorie ->
                                                              CategoryDto
                                                                      .builder()
                                                                      .name(subcategorie.getName())
                                                                      .subcategories(subcategorie.getSubcategories()
                                                                      .stream()
                                                                      .map(subsubcategorie ->
                                                                             CategoryDto.builder()
                                                                                        .name(subsubcategorie.getName())
                                                                                        .path(subsubcategorie.getPath())
                                                                                        .build())
                                                                                            .collect(Collectors.toList()))
                                                              .build()).collect(Collectors.toList()))
                          .build();
    }
}
