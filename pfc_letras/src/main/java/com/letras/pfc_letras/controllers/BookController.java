package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.dtos.book.BookDto;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.users.UserModel;
import com.letras.pfc_letras.models.users.UserRoles;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Resource
    private Facade facade;

    @GetMapping("/")
    public String books(Model model,
                        @RequestParam(value = "text", required = false) String text,
                        @RequestParam(value = "filter", required = false) List<String> filter,
                        HttpSession session) {

        if(filter!= null)
            filter.remove("[]");

        model.addAttribute("categories", facade.getAllGroupCategories());
        model.addAttribute("filter", filter);
        model.addAttribute("books", (Strings.isEmpty(text) && (filter==null || filter.isEmpty()))
                                                         ? facade.findAllBooks(): facade.searchBookByKey(text, filter));

        UserModel userModel = (UserModel) session.getAttribute("usersession");
        if (userModel != null) {
            model.addAttribute("user", facade.getUserDto(userModel).get());
            return (userModel.getRoles().contains(UserRoles.USER)) ? "index" : "admin-books";
        }

        return "index";
    }

    @GetMapping("/book/{id}")
    public String getBookDetails(Model model, @PathVariable String id, HttpSession session) {
        model.addAttribute("book", facade.findBookById(id).orElse(null));
        UserModel userModel = (UserModel) session.getAttribute("usersession");

        if (userModel != null)
            model.addAttribute("user", facade.getUserDto(userModel).get());

        return "book-details";
    }

    @GetMapping("/author/{id}")
    public String getAuthorDetails(Model model, @PathVariable String id, HttpSession session) {
        Optional<AuthorDetailsDto> authorDetailsDto = facade.findAuthorById(id);
        authorDetailsDto.ifPresent(author -> model.addAttribute("author", author));
        UserModel userModel = (UserModel) session.getAttribute("usersession");

        if (userModel != null)
            model.addAttribute("user", facade.getUserDto(userModel).get());

        return "author-details";
    }
}
