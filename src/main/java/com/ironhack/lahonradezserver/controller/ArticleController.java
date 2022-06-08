package com.ironhack.lahonradezserver.controller;

import com.ironhack.lahonradezserver.model.Article;
import com.ironhack.lahonradezserver.service.impl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    @ResponseStatus(HttpStatus.OK)
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @PostMapping("/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveArticle(@RequestBody @Valid Article article){
        articleService.saveArticle(article);
    }

    @PutMapping("/articles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArticle(@PathVariable Long id, @RequestBody @Valid Article article){
        articleService.updateArticle(id, article);
    }

    @DeleteMapping("/articles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
    }
}
