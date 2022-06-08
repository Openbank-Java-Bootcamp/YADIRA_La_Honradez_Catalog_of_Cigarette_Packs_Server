package com.ironhack.lahonradezserver.repository;

import com.ironhack.lahonradezserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
