package com.puremike.db;

import com.puremike.db.domain.Author;
import com.puremike.db.domain.Book;

public final class TestDataUtils {

    private TestDataUtils() {
    }

    public static Author createTestAuthor() {

        return Author.builder()
                .id(1L)
                .name("Michael E.")
                .age(26)
                .build();
    }

    public static Author createTestAuthorA() {

        return Author.builder()
                .id(2L)
                .name("Don E.")
                .age(30)
                .build();
    }

    public static Author createTestAuthorB() {

        return Author.builder()
                .id(3L)
                .name("Michael Curry")
                .age(47)
                .build();
    }

    public static Author createTestAuthorC() {

        return Author.builder()
                .id(4L)
                .name("Stephen Curry")
                .age(67)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("1245-2332")
                .title("First Book")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("4425-5563")
                .title("Second Book")
                .authorId(2L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("5567-9080")
                .title("Third Book")
                .authorId(3L)
                .build();
    }
}
