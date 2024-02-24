package com.rvs.api.controller;

import com.rvs.api.model.NewsArticle;
import com.rvs.api.service.NewsArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsArticleService newsArticleService;

    public NewsController(NewsArticleService newsArticleService) {
        this.newsArticleService = newsArticleService;
    }

    @GetMapping()
    public ResponseEntity<List<NewsArticle>> getAll(){
        return ResponseEntity.ok(newsArticleService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<NewsArticle> getById(@PathVariable(name = "id", required = false) UUID id){
        return ResponseEntity.ok(newsArticleService.getById(id));
    }
}
