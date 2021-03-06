package com.ironhack.lahonradezserver.service.impl;

import com.ironhack.lahonradezserver.model.Role;
import com.ironhack.lahonradezserver.model.User;
import com.ironhack.lahonradezserver.repository.RoleRepository;
import com.ironhack.lahonradezserver.repository.UserRepository;
import com.ironhack.lahonradezserver.service.interfaces.UserServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User userSignupDTO) {
        String username = userSignupDTO.getUsername();
        User userOp = userRepository.findByUsername(username);
        if(userOp != null){
            log.error("User already exist");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user already exist");
        }

        log.info("Saving a new user {} inside of the database", userSignupDTO.getName());
        Role role = roleRepository.findByName("USER_ROLE");
        User user = new User(userSignupDTO.getName(), userSignupDTO.getUsername(), userSignupDTO.getPassword(), role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User is found in the database: {}", username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }
}
