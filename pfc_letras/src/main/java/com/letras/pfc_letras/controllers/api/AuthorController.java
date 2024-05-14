package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.models.AuthorModel;
import com.letras.pfc_letras.services.AuthorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Resource
    private AuthorService authorService;


    @GetMapping("/all")
    public List<AuthorModel> getAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/author{id}")
    public AuthorModel getAuthorById(@PathVariable String id) {
        return authorService.findAuthorById(id)
                .orElse(null);
    }
}
