package com.puremike.db.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

//@Data - Pass the specific annotations instead of @Data which includes @Getter, @Setter, @EqualsAndHashCode, and @ToString
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq_seq")
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private Integer age;

}
