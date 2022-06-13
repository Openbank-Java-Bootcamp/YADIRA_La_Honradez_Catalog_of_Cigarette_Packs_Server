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

    @NotEmpty(message = "The tittle must not be empty.")
    private String title;

    @NotEmpty(message = "The author must not be empty.")
    @Size(min = 1, max = 50, message = "The author name must be between 1 and 50 characters")
    private String author;

    @NotEmpty(message = "The link must not be empty.")
    private String link;

    @NotEmpty(message = "The description must not be empty.")
    @Size(min = 1, max = 50, message = "The description must be between 1 and 255 characters")
    private String description;
}
