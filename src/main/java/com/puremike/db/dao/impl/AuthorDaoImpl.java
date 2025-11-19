package com.puremike.db.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.puremike.db.dao.AuthorDao;
import com.puremike.db.domain.Author;

@Configuration
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createAuthor(Author author) {

        final String sql = "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                author.getId(), author.getName(), author.getAge());
    }

    public Optional<Author> findAuthorById(long authorId) {
        String sql = "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1";
        List<Author> result = jdbcTemplate.query(
                sql,
                new AuthorRowMapper(),
                authorId);
        return result.stream().findFirst();
    }

    public static class AuthorRowMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        };
    }

    public List<Author> findAuthors() {
        String sql = "SELECT id, name, age FROM authors";
        return jdbcTemplate.query(sql, new AuthorRowMapper());
    }

    public void updateAuthorById(Author author, long authorId) {
        String sql = "UPDATE authors SET name = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, author.getName(), author.getAge(), authorId);
    }

}
