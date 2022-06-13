package com.ironhack.lahonradezserver.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVerifyDTO {
    private String user;
    private String role;
}
