package com.puremike.db.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @EqualsAndHashCode.Include
    private String isbn;

    private String title;

    // Mirror of the foreign key column, read-only
//    @Column(name = "author_id", insertable = false, updatable = false)
//    private Long authorId; // required for JDBC

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AuthorEntity author;

}
