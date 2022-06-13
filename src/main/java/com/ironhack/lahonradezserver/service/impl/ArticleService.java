package com.ironhack.lahonradezserver.service.impl;

import com.ironhack.lahonradezserver.model.Article;
import com.ironhack.lahonradezserver.repository.ArticleRepository;
import com.ironhack.lahonradezserver.service.interfaces.ArticleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements ArticleServiceInterface {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article saveArticle(Article article) {
        if(article.getId() != null) {
            Optional<Article> articleOp = articleRepository.findById(article.getId());
            if(articleOp.isPresent()){

                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The article already exist");
            }
        }
        Article artDB = articleRepository.findByLink(article.getLink());
        if(artDB != null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The article already exist");
        }
        return articleRepository.save(article);
    }

    @Override
    public void updateArticle(Long id, Article article) {
        Article articleDB = articleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article is not found"));
        article.setId(articleDB.getId());
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        Article articleDB = articleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article is not found"));
        articleRepository.deleteById(id);
    }
}
