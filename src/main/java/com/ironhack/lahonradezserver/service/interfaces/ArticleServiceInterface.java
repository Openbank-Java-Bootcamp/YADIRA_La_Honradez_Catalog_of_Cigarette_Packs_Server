package com.ironhack.lahonradezserver.service.interfaces;

import com.ironhack.lahonradezserver.model.Article;

import java.util.List;

public interface ArticleServiceInterface {
    void saveArticle(Article article);
    List<Article> getAllArticles();
    void updateArticle(Long id, Article article);
    void deleteArticle(Long id);

}
