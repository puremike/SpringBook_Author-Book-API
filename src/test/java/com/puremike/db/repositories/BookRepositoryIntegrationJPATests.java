
package com.puremike.db.repositories;

import java.util.List;
import java.util.Optional;

import com.puremike.db.TestDataJPAUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.puremike.db.domain.Author;
import com.puremike.db.domain.Book;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationJPATests {

    private final BookRepository underTest;
    private final AuthorRepository authorRepo;

    @Autowired
    public BookRepositoryIntegrationJPATests(BookRepository underTest, AuthorRepository authorRepo) {
        this.underTest = underTest;
        this.authorRepo = authorRepo;
    }

    private final Author author = TestDataJPAUtils.createTestAuthor();

    @Test
    public void testThatBookCanBeCreatedAndRetrieved() {
        Author newAuthor = authorRepo.save(author);

        Book book = TestDataJPAUtils.createTestBook(newAuthor);
        underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatBooksCanBeCreatedAndRetrieved() {
        Author newAuthor = authorRepo.save(author);

        Book book = TestDataJPAUtils.createTestBook(newAuthor);
        underTest.save(book);

        Book bookA = TestDataJPAUtils.createTestBookA(newAuthor);
        underTest.save(bookA);

        Book bookB = TestDataJPAUtils.createTestBookB(newAuthor);
        underTest.save(bookB);

        Iterable<Book> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(book, bookA, bookB);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataJPAUtils.createTestAuthorB();
        authorRepo.save(author);

        Book book = TestDataJPAUtils.createTestBookB(author);
        underTest.save(book);

        book.setTitle("Third Book Updated");
        underTest.save(book);

        Optional<Book> result = underTest.findById(book.getIsbn());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        Author newAuthor = authorRepo.save(author);

        Book book = TestDataJPAUtils.createTestBook(newAuthor);
        underTest.save(book);

        underTest.deleteById(book.getIsbn());
        Optional<Book> result = underTest.findById(book.getIsbn());

        assertThat(result).isEmpty();
    }
}
