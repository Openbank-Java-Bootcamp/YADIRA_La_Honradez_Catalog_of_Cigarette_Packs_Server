package com.ironhack.lahonradezserver.service.interfaces;

import com.ironhack.lahonradezserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);
    List<User> getUsers();
}
