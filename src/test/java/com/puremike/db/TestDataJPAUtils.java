package com.puremike.db;

import java.util.HashMap;
import java.util.Map;

import com.puremike.db.domain.AuthorEntity;
import com.puremike.db.domain.BookEntity;

public final class TestDataJPAUtils {

    private TestDataJPAUtils() {
    }

    public static AuthorEntity createTestAuthor() {

        return AuthorEntity.builder()
                .name("Michael E.")
                .age(26)
                .build();
    }

    public static AuthorEntity createTestAuthorA() {

        return AuthorEntity.builder()
                .name("Don E.")
                .age(30)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {

        return AuthorEntity.builder()
                .name("Michael Curry")
                .age(47)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {

        return AuthorEntity.builder()
                .name("Stephen Curry")
                .age(67)
                .build();
    }

    public static BookEntity createTestBook(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("1245-2332")
                .title("First Book")
                .author(author)
                .build();
    }

    public static BookEntity createTestBookA(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("4425-5563")
                .title("Second Book")
                .author(author)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity author) {
        return BookEntity.builder()
                .isbn("5567-9080")
                .title("Third Book")
                .author(author)
                .build();
    }

    public static Map<String, Object> createMapTestBook(AuthorEntity testAuthor) {

        Map<String, Object> map = new HashMap<>();
        map.put("isbn", "4425-5563");
        map.put("title", "First Book");
        map.put("author_id", testAuthor.getId());

        return map;

    }

    public static Map<String, Object> createMapTestBookA(AuthorEntity testAuthor) {

        Map<String, Object> map = new HashMap<>();
        map.put("isbn", "4425-5563");
        map.put("title", "Second Book");
        map.put("author_id", testAuthor.getId());

        return map;

    }

    public static Map<String, Object> createMapTestBookB(AuthorEntity testAuthor) {

        Map<String, Object> map = new HashMap<>();
        map.put("isbn", "5567-9080");
        map.put("title", "Third Book");
        map.put("author_id", testAuthor.getId());

        return map;

    }
}
