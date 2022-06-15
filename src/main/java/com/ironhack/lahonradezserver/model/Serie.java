package com.ironhack.lahonradezserver.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "The serial name must not be empty")
    private String titleS;
    private String descriptionS;
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<CigarettePack> cigarettePacks;
}
