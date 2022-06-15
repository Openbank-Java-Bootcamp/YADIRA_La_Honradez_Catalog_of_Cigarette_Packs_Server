package com.ironhack.lahonradezserver.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {
    @NotEmpty(message = "The user must not be empty")
    private String username;
    @NotEmpty(message = "The password must not be empty")
    private String password;
}
