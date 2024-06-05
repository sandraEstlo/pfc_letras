package com.letras.pfc_letras.controllers.api;

import com.letras.pfc_letras.dtos.author.AuthorDetailsDto;
import com.letras.pfc_letras.facades.Facade;
import com.letras.pfc_letras.models.AuthorModel;
import com.letras.pfc_letras.services.authors.AuthorService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class ApiAuthorController {

    @Resource
    private Facade facade;

    @Resource
    private AuthorService authorService;

    @GetMapping("/all")
    public List<AuthorModel> getAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable String id) {
        Optional<AuthorDetailsDto> authorDetailsDto = facade.findAuthorById(id);
        return authorDetailsDto.isPresent() ? ResponseEntity.ok(authorDetailsDto.get())
                                            : ResponseEntity.notFound().build();
    }

    @GetMapping("/details-2/{id}")
    public ResponseEntity<?> getAuthorById2(@PathVariable String id) {
        Optional<AuthorModel> authorModel = authorService.findAuthorById(id);
        return authorModel.isPresent() ? ResponseEntity.ok(authorModel.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/new")
    public AuthorModel newAuthor(@RequestBody AuthorModel authorModel) {
        return authorService.save(authorModel);
    }
}
