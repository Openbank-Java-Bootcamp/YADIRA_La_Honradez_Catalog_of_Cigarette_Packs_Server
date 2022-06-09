package com.ironhack.lahonradezserver.controller;

import com.ironhack.lahonradezserver.model.Article;
import com.ironhack.lahonradezserver.model.Topic;
import com.ironhack.lahonradezserver.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping("/topics")
    @ResponseStatus(HttpStatus.OK)
    public List<Topic> getAllTopics(){
        return topicRepository.findAll();
    }
}
