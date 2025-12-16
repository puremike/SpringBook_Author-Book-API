package com.puremike.db.controllers;

import com.puremike.db.domain.AuthorEntity;
import com.puremike.db.domain.dtos.AuthorDTO;
import com.puremike.db.mappers.Mapper;
import com.puremike.db.services.AuthorService;
import com.puremike.db.utils.ErrorResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorService authorService;
    private final Mapper<AuthorEntity, AuthorDTO> autoMapper;

    public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDTO> autoMapper) {
        this.authorService = authorService;
        this.autoMapper = autoMapper;
    }

    @PostMapping("/authors")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO author) {
        AuthorEntity autoEntity = autoMapper.mapFrom(author);
        AuthorEntity savedAutoEntity = authorService.createAuthor(autoEntity);
        return new ResponseEntity<>(autoMapper.mapTo(savedAutoEntity), HttpStatus.CREATED);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Object> getAuthor(@PathVariable Long id) {
        Optional<AuthorEntity> author = authorService.getAuthorById(id);

        if (author.isPresent()) {
            AuthorDTO authorDTO = autoMapper.mapTo(author.get());
            return new ResponseEntity<>(authorDTO, HttpStatus.OK);
        }

        Map<String, String> errorResponse = ErrorResponseUtil.createNotFoundResponse("Author", id);

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}