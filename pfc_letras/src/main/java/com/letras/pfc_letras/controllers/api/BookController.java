package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/all")
    public List<BookModel> getAuthors() {
        return bookService.findAllBooks();
    }

    @GetMapping("/category/{categories}")
    public List<BookModel> getByCategory(@PathVariable String... categories) {
        return bookService.findByCategories(categories);
    }

    @GetMapping("/name/{authorName}")
    public List<BookModel> getByAuthorName(@PathVariable String authorName) {
        return bookService.findByAuthorNameContainingIgnoreCase(authorName);
    }

    @GetMapping("/id/{authorId}")
    public List<BookModel> getByAuthor(@PathVariable String authorId) {
        return bookService.findByAuthorsContaining(authorId);
    }
}
