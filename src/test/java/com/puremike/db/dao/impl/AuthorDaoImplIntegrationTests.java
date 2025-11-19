package com.puremike.db.dao.impl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.puremike.db.TestDataUtils;
import com.puremike.db.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorDaoImplIntegrationTests {

    private final AuthorDaoImpl underTest;

    @Autowired
    public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRetrieved() {
        Author author = TestDataUtils.createTestAuthor();
        underTest.createAuthor(author);
        Optional<Author> result = underTest.findAuthorById(author.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatAuthorsCanBeCreatedAndRetrieved() {
        Author author = TestDataUtils.createTestAuthor();
        underTest.createAuthor(author);

        Author authorA = TestDataUtils.createTestAuthorA();
        underTest.createAuthor(authorA);

        Author authorB = TestDataUtils.createTestAuthorB();
        underTest.createAuthor(authorB);

        List<Author> result = underTest.findAuthors();
        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(author, authorA, authorB);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        Author author = TestDataUtils.createTestAuthorC();
        underTest.createAuthor(author);
        author.setName("Stephen UPDATED");

        underTest.updateAuthorById(author, author.getId());
        Optional<Author> result = underTest.findAuthorById(author.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

}
