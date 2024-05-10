package com.letras.pfc_letras.controllers.dto;

import com.letras.pfc_letras.models.Author;
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
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable String id) {
        return authorService.getAuthorById(id)
                            .orElse(null);
    }
}
