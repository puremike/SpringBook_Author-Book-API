package com.puremike.db;

import com.puremike.db.domain.Author;
import com.puremike.db.domain.Book;

public final class TestDataJPAUtils {

    private TestDataJPAUtils() {
    }

    public static Author createTestAuthor() {

        return Author.builder()
                .name("Michael E.")
                .age(26)
                .build();
    }

    public static Author createTestAuthorA() {

        return Author.builder()
                .name("Don E.")
                .age(30)
                .build();
    }

    public static Author createTestAuthorB() {

        return Author.builder()
                .name("Michael Curry")
                .age(47)
                .build();
    }

    public static Author createTestAuthorC() {

        return Author.builder()
                .name("Stephen Curry")
                .age(67)
                .build();
    }

    public static Book createTestBook(final Author author) {
        return Book.builder()
                .isbn("1245-2332")
                .title("First Book")
                .author(author)
                .build();
    }

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("4425-5563")
                .title("Second Book")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("5567-9080")
                .title("Third Book")
                .author(author)
                .build();
    }
}
