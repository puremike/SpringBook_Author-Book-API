package com.puremike.db.services.impl;

import com.puremike.db.domain.AuthorEntity;
import com.puremike.db.repositories.AuthorRepository;
import com.puremike.db.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity author){
        return authorRepository.save(author);
    }

    @Override
    public Optional<AuthorEntity> getAuthorById(Long authorId) {
        return authorRepository.findById(authorId);
    }
}
