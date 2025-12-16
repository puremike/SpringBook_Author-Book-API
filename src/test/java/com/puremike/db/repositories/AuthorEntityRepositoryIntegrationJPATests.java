package com.puremike.db.repositories;

import java.util.Optional;

import com.puremike.db.TestDataJPAUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import com.puremike.db.domain.AuthorEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorEntityRepositoryIntegrationJPATests {

    private final AuthorRepository underTest;

    @Autowired
    public AuthorEntityRepositoryIntegrationJPATests(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRetrieved() {
        AuthorEntity author = TestDataJPAUtils.createTestAuthor();
        underTest.save(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());

        assertThat(result).isPresent();
        AuthorEntity persisted = result.get();
        assertThat(persisted.getId()).isEqualTo(author.getId());
        assertThat(persisted.getName()).isEqualTo(author.getName());
        assertThat(persisted.getAge()).isEqualTo(author.getAge());
        assertThat(persisted).isEqualTo(author);
    }

    @Test
    public void testThatAuthorsCanBeCreatedAndRetrieved() {
        AuthorEntity author = TestDataJPAUtils.createTestAuthor();
        underTest.save(author);

        AuthorEntity authorA = TestDataJPAUtils.createTestAuthorA();
        underTest.save(authorA);

        AuthorEntity authorB = TestDataJPAUtils.createTestAuthorB();
        underTest.save(authorB);

        Iterable<AuthorEntity> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(author, authorA, authorB);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        AuthorEntity author = TestDataJPAUtils.createTestAuthorC();
        underTest.save(author);
        author.setName("Stephen UPDATED");

        underTest.save(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatAuthorCanBeCreatedAndDeleted() {
        AuthorEntity author = TestDataJPAUtils.createTestAuthorC();
        underTest.save(author);

        underTest.deleteById(author.getId());
        Optional<AuthorEntity> result = underTest.findById(author.getId());

        assertThat(result).isEmpty();
    }

    @Test
    public void testThatAuthorsAgeAreGreaterThan() {
        AuthorEntity author = TestDataJPAUtils.createTestAuthor();
        underTest.save(author);
        AuthorEntity authorA = TestDataJPAUtils.createTestAuthorA();
        underTest.save(authorA);
        AuthorEntity authorB = TestDataJPAUtils.createTestAuthorB();
        underTest.save(authorB);
        AuthorEntity authorC = TestDataJPAUtils.createTestAuthorC();
        underTest.save(authorC);

        Iterable<AuthorEntity> result = underTest.ageGreaterThan(26); // SPRING JPA automatically created the method
                                                                      // under the hood
        assertThat(result).containsExactly(authorA, authorB, authorC);
    }

    @Test
    public void testThatAuthorsAgeAreLessThan() {
        AuthorEntity author = TestDataJPAUtils.createTestAuthor();
        underTest.save(author);
        AuthorEntity authorA = TestDataJPAUtils.createTestAuthorA();
        underTest.save(authorA);
        AuthorEntity authorB = TestDataJPAUtils.createTestAuthorB();
        underTest.save(authorB);
        AuthorEntity authorC = TestDataJPAUtils.createTestAuthorC();
        underTest.save(authorC);

        Iterable<AuthorEntity> result = underTest.findAuthorsAgeLessThan(30);
        assertThat(result).containsExactly(author, authorA);
    }
}
