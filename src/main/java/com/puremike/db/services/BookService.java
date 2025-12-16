package com.puremike.db.services;

import java.util.Optional;

import com.puremike.db.domain.BookEntity;

public interface BookService {
    BookEntity createBook(BookEntity book);

    Optional<BookEntity> getBookByISBN(String isbn);

    BookEntity updateBook(BookEntity book, String isbn);
}
