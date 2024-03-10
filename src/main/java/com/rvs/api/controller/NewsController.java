package com.rvs.api.controller;

import com.rvs.api.model.DTOs.NewsArticleDTO;
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
     ResponseEntity<List<NewsArticle>> getAll(@RequestParam(required = false, name = "allNews") boolean allNews){
        return allNews ? ResponseEntity.ok(newsArticleService.getAll()) : ResponseEntity.ok(newsArticleService.getLastThree());
    }

    @GetMapping(path = "/{id}")
     ResponseEntity<NewsArticle> getById(@PathVariable(name = "id", required = false) UUID id){
        return ResponseEntity.ok(newsArticleService.getById(id));
    }

    @PostMapping()
    ResponseEntity<NewsArticle> createNewsArticle(@RequestBody NewsArticleDTO newsArticleDTO){
        NewsArticle newArticle = newsArticleService.saveArticle(newsArticleDTO);
        return ResponseEntity.ok(newArticle);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable(name = "id", required = true) UUID id){
        newsArticleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
