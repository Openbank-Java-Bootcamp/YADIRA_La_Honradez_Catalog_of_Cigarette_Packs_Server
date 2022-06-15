package com.ironhack.lahonradezserver.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The tittle must not be empty")
    private String title;

    @NotEmpty(message = "The author must not be empty")
    private String author;

    @NotEmpty(message = "The link must not be empty")
    private String link;

    @NotEmpty(message = "The description must not be empty")
    private String description;
}
