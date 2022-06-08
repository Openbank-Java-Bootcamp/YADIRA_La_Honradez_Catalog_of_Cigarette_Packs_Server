package com.ironhack.lahonradezserver.repository;

import com.ironhack.lahonradezserver.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
