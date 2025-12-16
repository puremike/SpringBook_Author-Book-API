//package com.puremike.db.dao.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//
//import com.puremike.db.TestDataUtils;
//import com.puremike.db.domain.AuthorEntity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class AuthorEntityDaoImplIntegrationTests {
//
//    private final AuthorDaoImpl underTest;
//
//    @Autowired
//    public AuthorEntityDaoImplIntegrationTests(AuthorDaoImpl underTest) {
//        this.underTest = underTest;
//    }
//
//    @Test
//    public void testThatAuthorCanBeCreatedAndRetrieved() {
//        AuthorEntity author = TestDataUtils.createTestAuthor();
//        underTest.createAuthor(author);
//        Optional<AuthorEntity> result = underTest.findAuthorById(author.getId());
//
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(author);
//    }
//
//    @Test
//    public void testThatAuthorsCanBeCreatedAndRetrieved() {
//        AuthorEntity author = TestDataUtils.createTestAuthor();
//        underTest.createAuthor(author);
//
//        AuthorEntity authorA = TestDataUtils.createTestAuthorA();
//        underTest.createAuthor(authorA);
//
//        AuthorEntity authorB = TestDataUtils.createTestAuthorB();
//        underTest.createAuthor(authorB);
//
//        List<AuthorEntity> result = underTest.findAuthors();
//        assertThat(result)
//                .hasSize(3)
//                .containsExactlyInAnyOrder(author, authorA, authorB);
//    }
//
//    @Test
//    public void testThatAuthorCanBeUpdated() {
//        AuthorEntity author = TestDataUtils.createTestAuthorC();
//        underTest.createAuthor(author);
//        author.setName("Stephen UPDATED");
//
//        underTest.updateAuthorById(author, author.getId());
//        Optional<AuthorEntity> result = underTest.findAuthorById(author.getId());
//
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(author);
//    }
//
//    @Test
//    public void testThatAuthorCanBeCreatedAndDeleted() {
//        AuthorEntity author = TestDataUtils.createTestAuthorC();
//        underTest.createAuthor(author);
//
//        underTest.deleteAuthorById(author.getId());
//        Optional<AuthorEntity> result = underTest.findAuthorById(author.getId());
//
//        assertThat(result).isEmpty();
//    }
//}
