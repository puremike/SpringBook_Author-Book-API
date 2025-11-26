package com.puremike.db.repositories;

import java.util.Optional;

import com.puremike.db.TestDataJPAUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import com.puremike.db.domain.Author;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationJPATests {

    private final AuthorRepository underTest;

    @Autowired
    public AuthorRepositoryIntegrationJPATests(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRetrieved() {
        Author author = TestDataJPAUtils.createTestAuthor();
        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());

        assertThat(result).isPresent();
        Author persisted = result.get();
        assertThat(persisted.getId()).isEqualTo(author.getId());
        assertThat(persisted.getName()).isEqualTo(author.getName());
        assertThat(persisted.getAge()).isEqualTo(author.getAge());
        assertThat(persisted).isEqualTo(author);
    }

    @Test
    public void testThatAuthorsCanBeCreatedAndRetrieved() {
        Author author = TestDataJPAUtils.createTestAuthor();
        underTest.save(author);

        Author authorA = TestDataJPAUtils.createTestAuthorA();
        underTest.save(authorA);

        Author authorB = TestDataJPAUtils.createTestAuthorB();
        underTest.save(authorB);

        Iterable<Author> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(author, authorA, authorB);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        Author author = TestDataJPAUtils.createTestAuthorC();
        underTest.save(author);
        author.setName("Stephen UPDATED");

        underTest.save(author);
        Optional<Author> result = underTest.findById(author.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatAuthorCanBeCreatedAndDeleted() {
        Author author = TestDataJPAUtils.createTestAuthorC();
        underTest.save(author);

        underTest.deleteById(author.getId());
        Optional<Author> result = underTest.findById(author.getId());

        assertThat(result).isEmpty();
    }

    @Test
    public void testThatAuthorsAgeAreGreaterThan() {
        Author author = TestDataJPAUtils.createTestAuthor();
        underTest.save(author);
        Author authorA = TestDataJPAUtils.createTestAuthorA();
        underTest.save(authorA);
        Author authorB = TestDataJPAUtils.createTestAuthorB();
        underTest.save(authorB);
        Author authorC = TestDataJPAUtils.createTestAuthorC();
        underTest.save(authorC);

        Iterable<Author> result = underTest.ageGreaterThan(26); // SPRING JPA automatically created the method under the hood
        assertThat(result).containsExactly(authorA, authorB, authorC);
    }

    @Test
    public void testThatAuthorsAgeAreLessThan() {
        Author author = TestDataJPAUtils.createTestAuthor();
        underTest.save(author);
        Author authorA = TestDataJPAUtils.createTestAuthorA();
        underTest.save(authorA);
        Author authorB = TestDataJPAUtils.createTestAuthorB();
        underTest.save(authorB);
        Author authorC = TestDataJPAUtils.createTestAuthorC();
        underTest.save(authorC);

        Iterable<Author> result = underTest.findAuthorsAgeLessThan(30);
        assertThat(result).containsExactly(author, authorA);
    }
}
