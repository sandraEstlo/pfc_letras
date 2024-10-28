package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.CategoryModel;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CategoryRepository extends MongoRepository<CategoryModel, String> {

    @Aggregation(pipeline = {
            "{ $addFields: {pathArray: {$split: ['$path', ',']}}}",
            "{ $group: {_id: { category: { $arrayElemAt: ['$pathArray', 0] }, subcategory: { $arrayElemAt: ['$pathArray', 1] } },subcategories: { $push: { name: '$name', path: '$path' }}}}",
            "{ $group: {_id: '$_id.category', subcategories: { $push: { name: '$_id.subcategory', subcategories: { $filter: { input: '$subcategories', as: 'subcat', cond: { $ne: ['$$subcat.name', '$_id.subcategory'] }}}}}}}",
            "{ $addFields: {subcategories: {$filter: {input: '$subcategories', as: 'subcat', cond: { $ne: ['$$subcat.name', '$_id.category']}}}}}",
            "{ $sort: { '_id': 1, 'category': 1 } }",
            "{ $project: { '_id': 0, 'path': 1, 'name': '$_id', 'subcategories': 1 } }"
    })
    List<CategoryModel> findAllUsingAggregation();
}
