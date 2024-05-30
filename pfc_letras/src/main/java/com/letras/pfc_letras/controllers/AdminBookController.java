package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.facades.Facade;
import jakarta.annotation.Resource;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminBookController {

    @Resource
    private Facade facade;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/books")
    public String books(Model model, @RequestParam(value = "text", required = false) String text) {
        List<BookDto> books = (Strings.isEmpty(text)) ? facade.findAllBooks()
                                                      : facade.searchBookByKey(text);
        model.addAttribute("books", books);
        return "admin-books";
    }
}
