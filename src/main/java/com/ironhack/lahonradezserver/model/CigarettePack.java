package com.ironhack.lahonradezserver.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CigarettePack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "The tittle of the cigarette pack must not be empty.")
    private String titleCP;
    private String descriptionCP;
    @Lob
    private String link;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "serial_id")
    private Serie serie;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Topic> topics = new ArrayList<>();
}
