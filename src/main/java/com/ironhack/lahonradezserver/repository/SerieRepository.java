package com.ironhack.lahonradezserver.repository;

import com.ironhack.lahonradezserver.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Serie findByTitleS(String title);
}
