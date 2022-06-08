package com.ironhack.lahonradezserver.repository;

import com.ironhack.lahonradezserver.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerialRepository extends JpaRepository<Serie, Long> {
}
