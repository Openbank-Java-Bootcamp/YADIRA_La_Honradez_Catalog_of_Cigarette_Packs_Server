package com.ironhack.lahonradezserver.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CigarettePackDTO {
    private Long id;
    @NotEmpty(message = "The tittle must not be empty.")
    private String title;
    @NotEmpty(message = "The description must not be empty.")
    private String description;
    private String link;
    private List<String> topics;
    private String serieName;

}
