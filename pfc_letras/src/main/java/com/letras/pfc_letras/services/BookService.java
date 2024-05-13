package com.letras.pfc_letras.services;

import com.letras.pfc_letras.models.BookModel;
import java.util.List;

public interface BookService {

    List<BookModel> findAllBooks();
}
