package com.puremike.db.controllers;

import com.puremike.db.domain.BookEntity;
import com.puremike.db.domain.dtos.BookDTO;
import com.puremike.db.mappers.Mapper;
import com.puremike.db.services.BookService;
import com.puremike.db.utils.ErrorResponseUtil;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BookController {

    private final BookService bookService;
    private final Mapper<BookEntity, BookDTO> bookMapper;

    public BookController(BookService bookService, Mapper<BookEntity, BookDTO> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping("/books")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO book) {
        BookEntity bookEntity = bookMapper.mapFrom(book);
        BookEntity savedBookEntity = bookService.createBook(bookEntity);

        return new ResponseEntity<>(bookMapper.mapTo(savedBookEntity),
                HttpStatus.CREATED);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Object> getBook(@PathVariable String isbn) {

        Optional<BookEntity> book = bookService.getBookByISBN(isbn);

        if (book.isPresent()) {
            return new ResponseEntity<>(bookMapper.mapTo(book.get()), HttpStatus.OK);
        }

        Map<String, String> errorResponse = ErrorResponseUtil.createNotFoundResponse("Book", isbn);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    @PatchMapping("/books/{isbn}")
    public ResponseEntity<Object> updateBook(BookDTO book, @PathVariable String isbn) {
        BookEntity bookEntity = bookMapper.mapFrom(book);
        BookEntity updatedBookEntity = bookService.updateBook(bookEntity, isbn);

        if (updatedBookEntity != null) {
            String message = "Book with ISBN " + isbn + " is updated successfully";
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        Map<String, String> errorResponse = ErrorResponseUtil.createFailedResponse("Book");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
