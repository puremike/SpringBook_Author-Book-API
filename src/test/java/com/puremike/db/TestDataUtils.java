//package com.puremike.db;
//
//import com.puremike.db.domain.AuthorEntity;
//import com.puremike.db.domain.BookEntity;
//
//public final class TestDataUtils {
//
//    private TestDataUtils() {
//    }
//
//    public static AuthorEntity createTestAuthor() {
//
//        return AuthorEntity.builder()
//                .id(1L)
//                .name("Michael E.")
//                .age(26)
//                .build();
//    }
//
//    public static AuthorEntity createTestAuthorA() {
//
//        return AuthorEntity.builder()
//                .id(2L)
//                .name("Don E.")
//                .age(30)
//                .build();
//    }
//
//    public static AuthorEntity createTestAuthorB() {
//
//        return AuthorEntity.builder()
//                .id(3L)
//                .name("Michael Curry")
//                .age(47)
//                .build();
//    }
//
//    public static AuthorEntity createTestAuthorC() {
//
//        return AuthorEntity.builder()
//                .id(4L)
//                .name("Stephen Curry")
//                .age(67)
//                .build();
//    }
//
//    public static BookEntity createTestBook() {
//        return BookEntity.builder()
//                .isbn("1245-2332")
//                .title("First Book")
//                .authorId(1L)
//                .build();
//    }
//
//    public static BookEntity createTestBookA() {
//        return BookEntity.builder()
//                .isbn("4425-5563")
//                .title("Second Book")
//                .authorId(2L)
//                .build();
//    }
//
//    public static BookEntity createTestBookB() {
//        return BookEntity.builder()
//                .isbn("5567-9080")
//                .title("Third Book")
//                .authorId(3L)
//                .build();
//    }
//}
