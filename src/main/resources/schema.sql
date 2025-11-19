DROP TABLE IF EXISTS "books";
DROP TABLE IF EXISTS "authors";

CREATE TABLE authors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age integer
);

CREATE TABLE books (
    isbn VARCHAR(100) NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author_id bigint,
    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);