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
//import com.puremike.db.dao.AuthorDao;
//import com.puremike.db.domain.AuthorEntity;
//import com.puremike.db.domain.BookEntity;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class BookEntityDaoImplIntegrationTests {
//
//    private final BookDaoImpl underTest;
//    private final AuthorDao authorDao;
//
//    @Autowired
//    public BookEntityDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDao authorDao) {
//        this.underTest = underTest;
//        this.authorDao = authorDao;
//    }
//
//    private final AuthorEntity author = TestDataUtils.createTestAuthor();
//
//    @Test
//    public void testThatBookCanBeCreatedAndRetrieved() {
//        authorDao.createAuthor(author);
//
//        BookEntity book = TestDataUtils.createTestBook();
//        book.setAuthorId(author.getId());
//        underTest.createBook(book);
//        Optional<BookEntity> result = underTest.findBookByISBN(book.getIsbn());
//
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testThatBooksCanBeCreatedAndRetrieved() {
//        authorDao.createAuthor(author);
//
//        BookEntity book = TestDataUtils.createTestBook();
//        book.setAuthorId(author.getId());
//        underTest.createBook(book);
//
//        BookEntity bookA = TestDataUtils.createTestBookA();
//        bookA.setAuthorId(author.getId());
//        underTest.createBook(bookA);
//
//        BookEntity bookB = TestDataUtils.createTestBookB();
//        bookB.setAuthorId(author.getId());
//        underTest.createBook(bookB);
//
//        List<BookEntity> result = underTest.findBooks();
//        assertThat(result)
//                .hasSize(3)
//                .containsExactlyInAnyOrder(book, bookA, bookB);
//    }
//
//    @Test
//    public void testThatBookCanBeUpdated() {
//        AuthorEntity author = TestDataUtils.createTestAuthorB();
//        authorDao.createAuthor(author);
//
//        BookEntity book = TestDataUtils.createTestBookB();
//        underTest.createBook(book);
//
//        book.setTitle("Third Book Updated");
//        underTest.updateBookByISBN(book, book.getIsbn());
//
//        Optional<BookEntity> result = underTest.findBookByISBN(book.getIsbn());
//
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted() {
//        authorDao.createAuthor(author);
//
//        BookEntity book = TestDataUtils.createTestBook();
//        book.setAuthorId(author.getId());
//        underTest.createBook(book);
//
//        underTest.deleteBookByISBN(book.getIsbn());
//        Optional<BookEntity> result = underTest.findBookByISBN(book.getIsbn());
//
//        assertThat(result).isEmpty();
//    }
//}
