package com.ironhack.lahonradezserver.DTO;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CigarettePackDTO {
    private String title;
    private String description;
    private String link;
    private List<Long> topics;
    private String serieName;
}
