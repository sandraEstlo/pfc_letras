package com.letras.pfc_letras.services.books.impl;

import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.repositories.BookRepository;
import com.letras.pfc_letras.services.books.BookSearchService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor

@Service
public class BookSearchServiceImpl implements BookSearchService {

    @Resource
    private final MongoTemplate mongoTemplate;

    @Resource
    private final BookRepository bookRepository;

    @Override
    public List<BookModel> KeywordsSearch(String text, List<String> filter) {
        Set<BookModel> resultSearch = new HashSet<>();

        if (!text.isEmpty()) {
            Criteria criteria = new Criteria().orOperator(
                    Criteria.where("title").regex(".*" + text + ".*", "i"),
                    Criteria.where("description").regex(".*" + text + ".*", "i"),
                    Criteria.where("isbn").regex(".*" + text + ".*", "i"),
                    Criteria.where("label").regex(".*" + text + ".*", "i")
            );
            Query query = new Query(criteria);

            resultSearch.addAll(mongoTemplate.find(query, BookModel.class));
            resultSearch.addAll(bookRepository.findByAuthorsNameContainingIgnoreCase(text));
        }
        if (!filter.isEmpty())
            resultSearch.addAll(bookRepository.findByCategories(filter));

        return resultSearch.stream().distinct().collect(Collectors.toList());
    }
}
