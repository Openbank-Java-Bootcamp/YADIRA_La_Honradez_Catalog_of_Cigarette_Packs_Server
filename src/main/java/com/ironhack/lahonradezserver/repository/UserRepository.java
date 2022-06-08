package com.ironhack.lahonradezserver.repository;

import com.ironhack.lahonradezserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
}
