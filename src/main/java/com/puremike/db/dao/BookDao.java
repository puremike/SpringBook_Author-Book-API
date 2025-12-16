package com.puremike.db.dao;

import java.util.List;
import java.util.Optional;

import com.puremike.db.domain.BookEntity;

public interface BookDao {
    void createBook(BookEntity book);

    Optional<BookEntity> findBookByISBN(String isbn);

    List<BookEntity> findBooks();

    void updateBookByISBN(BookEntity book, String isbn);

    void deleteBookByISBN(String isbn);
};
