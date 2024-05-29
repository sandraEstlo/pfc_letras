package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.facades.Facade;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Resource
    private Facade facade;

    @GetMapping("/")
    public String books(Model model, @RequestParam(value = "text", required = false) String text) {
        List<BookDto> books = (Strings.isEmpty(text)) ? facade.findAllBooks()
                : facade.searchBookByKey(text);
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/book/{id}")
    public String getBookDetails(Model model, @PathVariable String id) {
        model.addAttribute("book", facade.findBookById(id).orElse(null));
        return "book-details";
    }

    @GetMapping("/author/{id}")
    public String getAuthorDetails(Model model, @PathVariable String id) {
        Optional<AuthorDetailsDto> authorDetailsDto = facade.findAuthorById(id);
        authorDetailsDto.ifPresent(author -> model.addAttribute("author", author));
        return "author-details";
    }
}
