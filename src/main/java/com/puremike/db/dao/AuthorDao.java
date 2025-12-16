package com.puremike.db.dao;

import java.util.List;
import java.util.Optional;

import com.puremike.db.domain.AuthorEntity;

public interface AuthorDao {
    void createAuthor(AuthorEntity author);

    Optional<AuthorEntity> findAuthorById(long authorId);

    List<AuthorEntity> findAuthors();

    void updateAuthorById(AuthorEntity author, long authorId);

    void deleteAuthorById(Long id);
}
