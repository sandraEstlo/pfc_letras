package com.letras.pfc_letras.controllers;

import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.facades.Facade;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@Controller
public class AuthorController {

//    @Resource
//    private Facade facade;
//
//    @GetMapping("/author/{id}")
//    public String getAuthorDetails(Model model, @PathVariable String id) {
//        Optional<AuthorDetailsDto> authorDetailsDto = facade.findAuthorById(id);
//        authorDetailsDto.ifPresent(author -> model.addAttribute("author", author));
//        return "author-details";
//    }
}
