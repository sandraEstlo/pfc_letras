package com.letras.pfc_letras.services.books;

import com.letras.pfc_letras.models.BookModel;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface BookSearchService {

    List<BookModel> KeywordsSearch(String text, List<String> filter);
}
