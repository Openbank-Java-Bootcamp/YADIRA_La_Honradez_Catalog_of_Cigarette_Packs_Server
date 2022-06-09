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
    @NotNull(message = "The tittle of the article must not be empty.")
    private String title;
    @NotNull(message = "The name of the author must not be empty.")
    private String author;
    private String link;
    private String description;
}
