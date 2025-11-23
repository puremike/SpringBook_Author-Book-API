package com.puremike.db.dao;

import java.util.List;
import java.util.Optional;

import com.puremike.db.domain.Book;

public interface BookDao {
    void createBook(Book book);

    Optional<Book> findBookByISBN(String isbn);

    List<Book> findBooks();

    void updateBookByISBN(Book book, String isbn);

    void deleteBookByISBN(String isbn);
};
