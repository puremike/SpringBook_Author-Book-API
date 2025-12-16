package com.puremike.db.repositories;

import com.puremike.db.domain.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
    Iterable<AuthorEntity> ageGreaterThan(int age);

    // HQL
    @Query("SELECT a from AuthorEntity a WHERE a.age <= ?1")
    Iterable<AuthorEntity> findAuthorsAgeLessThan(int i);
}
