package com.puremike.db.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.puremike.db.dao.BookDao;
import com.puremike.db.domain.Book;

@Configuration
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createBook(Book book) {
        final String sql = "INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, book.getIsbn(), book.getTitle(), book.getAuthorId());
    }

    @Override
    public Optional<Book> findBookByISBN(String isbn) {
        String sql = "SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1";

        List<Book> result = jdbcTemplate.query(sql, new BookRowMapper(), isbn);

        return result.stream().findFirst();
    };

    public static class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .authorId(rs.getLong("author_id"))
                    .build();
        }
    };

    @Override
    public List<Book> findBooks() {
        String sql = "SELECT isbn, title, author_id FROM books";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public void updateBookByISBN(Book book, String isbn) {
        String sql = "UPDATE books SET title = ?, author_id = ? WHERE isbn = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthorId(), isbn);
    };

}