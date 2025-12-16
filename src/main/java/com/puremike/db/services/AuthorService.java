package com.puremike.db.services;

import com.puremike.db.domain.AuthorEntity;

import java.util.Optional;

public interface AuthorService {
    AuthorEntity createAuthor(AuthorEntity author);
    Optional<AuthorEntity> getAuthorById(Long authorId);
}
