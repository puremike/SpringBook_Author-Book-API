package com.puremike.db.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private String isbn;
    private String title;

    @JsonProperty("author_id")
    private Long authorId;
}
