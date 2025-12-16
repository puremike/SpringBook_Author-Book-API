//package com.puremike.db.dao.impl;
//
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import com.puremike.db.TestDataUtils;
//import com.puremike.db.domain.BookEntity;
//
//@ExtendWith(MockitoExtension.class)
//public class BookEntityDaoImplTests {
//
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private BookDaoImpl underTest;
//
//    @Test
//    public void testThatCreateBookGenerateCorrectSql() {
//        BookEntity book = TestDataUtils.createTestBook();
//        underTest.createBook(book);
//
//        verify(jdbcTemplate).update(
//                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
//                eq("1245-2332"),
//                eq("First Book"),
//                eq(1L));
//    }
//
//    @Test
//    public void testThatFindBookByISBNGeneratesTheCorrectSql() {
//        underTest.findBookByISBN("1245-2332");
//
//        verify(jdbcTemplate).query(
//                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
//                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
//                eq("1245-2332"));
//    };
//
//    @Test
//    public void testThatFindBooksGeneratesTheCorrectSql() {
//        underTest.findBooks();
//
//        verify(jdbcTemplate).query(
//                eq("SELECT isbn, title, author_id FROM books"),
//                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());
//    };
//
//    @Test
//    public void testThatUpdateBookByISBNGeneratesTheCorrectSql() {
//        underTest.updateBookByISBN(TestDataUtils.createTestBookB(), "5567-9080");
//
//        verify(jdbcTemplate).update(
//                eq("UPDATE books SET title = ?, author_id = ? WHERE isbn = ?"),
//                eq("Third Book"),
//                eq(3L),
//                eq("5567-9080"));
//    }
//
//    @Test
//    public void testThatDeleteBookByISBNFGeneratesTheCorrectSql() {
//        underTest.deleteBookByISBN("5567-9080");
//
//        verify(jdbcTemplate).update(
//                eq("DELETE FROM books WHERE isbn = ?"),
//                eq("5567-9080"));
//    }
//}
