package com.ironhack.lahonradezserver.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CigarettePackDTO {
    private Long id;
    @NotEmpty(message = "The tittle must not be empty")
    private String title;
    @NotEmpty(message = "The description must not be empty")
    private String description;
    @NotEmpty(message = "The image must not be empty")
    private String link;
    @NotEmpty(message = "You must select al least one topic")
    private List<String> topics;
    @NotEmpty(message = "The tittle of the series must not be empty")
    private String serieName;

}
