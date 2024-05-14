package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.services.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController01 {

    @Resource
    BookService bookService;

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books",bookService.findAllBooks());
        return "index";
    }
}
