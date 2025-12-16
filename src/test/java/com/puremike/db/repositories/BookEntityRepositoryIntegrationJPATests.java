
package com.puremike.db.repositories;

import java.util.Optional;

import com.puremike.db.TestDataJPAUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.puremike.db.domain.AuthorEntity;
import com.puremike.db.domain.BookEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationJPATests {

    private final BookRepository underTest;
    private final AuthorRepository authorRepo;

    @Autowired
    public BookEntityRepositoryIntegrationJPATests(BookRepository underTest, AuthorRepository authorRepo) {
        this.underTest = underTest;
        this.authorRepo = authorRepo;
    }

    private final AuthorEntity author = TestDataJPAUtils.createTestAuthor();

    @Test
    public void testThatBookCanBeCreatedAndRetrieved() {
        AuthorEntity newAuthor = authorRepo.save(author);

        BookEntity book = TestDataJPAUtils.createTestBook(newAuthor);
        underTest.save(book);
        Optional<BookEntity> result = underTest.findById(book.getIsbn());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatBooksCanBeCreatedAndRetrieved() {
        AuthorEntity newAuthor = authorRepo.save(author);

        BookEntity book = TestDataJPAUtils.createTestBook(newAuthor);
        underTest.save(book);

        BookEntity bookA = TestDataJPAUtils.createTestBookA(newAuthor);
        underTest.save(bookA);

        BookEntity bookB = TestDataJPAUtils.createTestBookB(newAuthor);
        underTest.save(bookB);

        Iterable<BookEntity> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactlyInAnyOrder(book, bookA, bookB);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        AuthorEntity author = TestDataJPAUtils.createTestAuthorB();
        authorRepo.save(author);

        BookEntity book = TestDataJPAUtils.createTestBookB(author);
        underTest.save(book);

        book.setTitle("Third Book Updated");
        underTest.save(book);

        Optional<BookEntity> result = underTest.findById(book.getIsbn());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        AuthorEntity newAuthor = authorRepo.save(author);

        BookEntity book = TestDataJPAUtils.createTestBook(newAuthor);
        underTest.save(book);

        underTest.deleteById(book.getIsbn());
        Optional<BookEntity> result = underTest.findById(book.getIsbn());

        assertThat(result).isEmpty();
    }
}
