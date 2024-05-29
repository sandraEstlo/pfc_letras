package com.letras.pfc_letras.services;

import com.letras.pfc_letras.models.BookModel;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface BookSearchService {

    List<BookModel> KeywordsSearch(String text);
}
