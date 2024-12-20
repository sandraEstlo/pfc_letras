package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.dtos.category.CategoryDto;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.BookModel;
import com.letras.pfc_letras.models.CategoryModel;
import com.letras.pfc_letras.repositories.BookRepository;
import com.letras.pfc_letras.repositories.CategoryRepository;
import com.letras.pfc_letras.services.books.BookSearchService;
import com.letras.pfc_letras.services.books.BookService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class ApiBookController {

    @Resource
    private BookService bookService;

    @Resource
    private BookSearchService bookSearchService;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private Facade facade;


    @Resource
    private CategoryRepository categoriesRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAuthors() {
        List<BookModel> listBooks = bookService.findAllBooks();
        return listBooks.isEmpty() ? ResponseEntity.noContent().build()
                                   : ResponseEntity.ok(listBooks);
    }

    @GetMapping("/all-page")
    public ResponseEntity<?> getBooksByPage( @PageableDefault(size = 2) Pageable pageable) {
        return ResponseEntity.ok(bookService.findAllBooks(pageable));
    }

    @GetMapping("/category")
    public ResponseEntity<?> getByCategory(@RequestBody List<String> categories) {
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
        List<BookModel> listBooks = bookService.findByIdAuthorsContaining(authorId);
        return listBooks.isEmpty() ? ResponseEntity.notFound().build()
                                   : ResponseEntity.ok(listBooks);
    }

//    @GetMapping("/search/{text}")
//    public ResponseEntity<?> getByText(@PathVariable String text) {
//        List<BookModel> listBooks = bookSearchService.KeywordsSearch(text);
//        return listBooks.isEmpty() ? ResponseEntity.notFound().build()
//                                   : ResponseEntity.ok(listBooks);
//    }

    @PostMapping("/find-by-category")
    public List<BookModel> findByCategory(@RequestBody List<String> categories) {
        return bookRepository.findByCategories(categories);
    }

    @GetMapping("/categories")
    public List<CategoryDto> getCategories() {
        return facade.getAllGroupCategories();
    }
}
