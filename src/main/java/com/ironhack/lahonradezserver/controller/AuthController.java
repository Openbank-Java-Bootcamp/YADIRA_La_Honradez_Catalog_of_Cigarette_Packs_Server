package com.ironhack.lahonradezserver.controller;

import com.google.gson.Gson;
import com.ironhack.lahonradezserver.DTO.UserVerifyDTO;
import com.ironhack.lahonradezserver.model.User;
import com.ironhack.lahonradezserver.repository.UserRepository;
import com.ironhack.lahonradezserver.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public String verifyToken(Authentication authentication) {
        String username = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByUserName(username);
        UserVerifyDTO userVerifyDTO = new UserVerifyDTO(userFromDb.getName());
        Gson gson = new Gson();
        String userDetails = gson.toJson(userVerifyDTO);
        return userDetails;
    }
}
