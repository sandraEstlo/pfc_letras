package com.letras.pfc_letras.services.books;

import com.letras.pfc_letras.models.BookModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface BookSearchService {

    Page<BookModel> KeywordsSearch(String text, List<String> filter, Pageable pageable);
}
