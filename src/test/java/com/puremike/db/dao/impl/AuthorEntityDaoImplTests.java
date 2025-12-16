//package com.puremike.db.dao.impl;
//
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import com.puremike.db.TestDataUtils;
//import com.puremike.db.domain.AuthorEntity;
//
//@ExtendWith(MockitoExtension.class)
//public class AuthorEntityDaoImplTests {
//
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private AuthorDaoImpl underTest;
//
//    @Test
//    public void testThatCreateAuthorGenerateCorrectSql() {
//        AuthorEntity author = TestDataUtils.createTestAuthor();
//        underTest.createAuthor(author);
//
//        verify(jdbcTemplate).update(
//                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
//                eq(1L),
//                eq("Michael E."),
//                eq(26));
//    }
//
//    @Test
//    public void testThatFindOneGeneratesTheCorrectSql() {
//        underTest.findAuthorById(1L);
//
//        verify(jdbcTemplate).query(
//                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
//                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(), eq(1L));
//    }
//
//    @Test
//    public void testThatFindAuthorsGeneratesTheCorrectSql() {
//        underTest.findAuthors();
//
//        verify(jdbcTemplate).query(
//                eq("SELECT id, name, age FROM authors"),
//                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
//    }
//
//    @Test
//    public void testThatUpdateAuthorByIdGeneratesTheCorrectSql() {
//
//        underTest.updateAuthorById(
//                TestDataUtils.createTestAuthorC(), 4L);
//
//        verify(jdbcTemplate).update(
//                eq("UPDATE authors SET name = ?, age = ? WHERE id = ?"),
//                eq("Stephen Curry"),
//                eq(67),
//                eq(4L));
//    }
//
//    @Test
//    public void testThatDeleteAuthorByIdGeneratesTheCorrectSql() {
//        underTest.deleteAuthorById(4L);
//
//        verify(jdbcTemplate).update(
//                eq("DELETE FROM authors WHERE id = ?"),
//                eq(4L));
//
//    }
//
//}
