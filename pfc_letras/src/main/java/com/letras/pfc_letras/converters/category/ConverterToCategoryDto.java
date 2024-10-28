package com.letras.pfc_letras.converters.category;

import com.letras.pfc_letras.dtos.category.CategoryDto;
import com.letras.pfc_letras.models.CategoryModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.Comparator;
import java.util.stream.Collectors;

@Component
public class ConverterToCategoryDto implements Converter<CategoryModel, CategoryDto> {

    @Override
    public CategoryDto convert(CategoryModel categoryModel) {
        String categoryName = categoryModel.getName().toLowerCase().substring(0, 2);

        return CategoryDto
                .builder()
                .name(categoryModel.getName())
                .subcategories(categoryModel
                        .getSubcategories()
                        .stream()
                        .map(subcategorie ->
                                CategoryDto
                                        .builder()
                                        .name(subcategorie.getName())
                                        .classGroup(categoryName+"-"+categoryModel.getSubcategories().indexOf(subcategorie))
                                        .subcategories(subcategorie.getSubcategories()
                                                .stream()
                                                .map(subsubcategorie ->
                                                        CategoryDto
                                                                .builder()
                                                                .name(subsubcategorie.getName())
                                                                .path(subsubcategorie.getPath())
                                                                .classGroup(categoryName+"-"+categoryModel
                                                                             .getSubcategories().indexOf(subcategorie))
                                                                    .build())
                                                                    .collect(Collectors.toList()))
                                                                    .build())
                                                                    .sorted(Comparator.comparing(CategoryDto::getName))
                                                                    .collect(Collectors.toList()))
                          .build();
    }
}
