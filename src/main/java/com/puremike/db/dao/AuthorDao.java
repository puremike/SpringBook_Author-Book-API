package com.puremike.db.dao;

import java.util.List;
import java.util.Optional;

import com.puremike.db.domain.Author;

public interface AuthorDao {
    void createAuthor(Author author);

    Optional<Author> findAuthorById(long authorId);

    List<Author> findAuthors();

    void updateAuthorById(Author author, long authorId);
}
