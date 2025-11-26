package com.puremike.db.repositories;

import com.puremike.db.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> ageGreaterThan(int age);

    @Query("SELECT a from Author a WHERE a.age <= ?1")
    Iterable<Author> findAuthorsAgeLessThan(int i);
}
