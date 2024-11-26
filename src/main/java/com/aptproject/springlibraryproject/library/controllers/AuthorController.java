package com.aptproject.springlibraryproject.library.controllers;

import com.aptproject.springlibraryproject.library.dto.AuthorDTO;
import com.aptproject.springlibraryproject.library.model.Author;
import com.aptproject.springlibraryproject.library.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors") // http://localhost:8080/authors
@Tag(name = "Авторы", description = "Контроллер для работы с авторами из библиотеки")
public class AuthorController
        extends GenericController<Author, AuthorDTO> {

    public AuthorController(AuthorService authorService) {
        super(authorService);
    }

    @Operation(description = "Добавить книгу к автору")
    @RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDTO> addBook(@RequestParam(value = "bookId") Long bookId,
                                             @RequestParam(value = "authorId") Long authorId) {
        return ResponseEntity.status(HttpStatus.OK).body(((AuthorService) service).addBook(bookId, authorId));
    }

}