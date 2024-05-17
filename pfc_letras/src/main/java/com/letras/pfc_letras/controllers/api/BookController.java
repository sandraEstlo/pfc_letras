package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<?> getAuthors() {
        List<BookModel> listBooks = bookService.findAllBooks();
        return listBooks.isEmpty() ? ResponseEntity.noContent().build()
                                   : ResponseEntity.ok(listBooks);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getByCategory(@RequestBody String ... categories) {
        List<BookModel> listBooks = bookService.findByCategories(categories);
        return listBooks.isEmpty() ? ResponseEntity.noContent().build()
                                   : ResponseEntity.ok(listBooks);
    }

    @GetMapping("/author-name/{authorName}")
    public ResponseEntity<?> getByAuthorName(@PathVariable String authorName) {
        List<BookModel> listBooks = bookService.findByAuthorNameContainingIgnoreCase(authorName);
        return listBooks.isEmpty() ? ResponseEntity.notFound().build()
                                   : ResponseEntity.ok(listBooks);
    }

    @GetMapping("/author-id/{authorId}")
    public ResponseEntity<?> getByAuthor(@PathVariable String authorId) {
        List<BookModel> listBooks = bookService.findByAuthorsContaining(authorId);
        return listBooks.isEmpty() ? ResponseEntity.notFound().build()
                                   : ResponseEntity.ok(listBooks);
    }
}
