package com.puremike.db.services.impl;

import com.puremike.db.domain.AuthorEntity;
import com.puremike.db.domain.BookEntity;
import com.puremike.db.repositories.BookRepository;
import com.puremike.db.services.AuthorService;
import com.puremike.db.services.BookService;

import lombok.extern.java.Log;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@Log
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public BookEntity createBook(BookEntity book) {
        // Get the Author
        Long authorId = book.getAuthor().getId();
        AuthorEntity author = authorService.getAuthorById(authorId)
                .orElseThrow(() -> new RuntimeException("Author with the ID " + authorId + " is not found"));

        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Optional<BookEntity> getBookByISBN(String isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public BookEntity updateBook(BookEntity book, String isbn) {
        BookEntity existingBook = getBookByISBN(isbn)
                .orElseThrow(() -> new RuntimeException("Book with the ISBN " + isbn + " is not found"));

        log.info("Existing Book ISBN: " + existingBook.getIsbn());

        return bookRepository.save(book);
    }
}
