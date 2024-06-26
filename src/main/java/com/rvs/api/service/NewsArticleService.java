package com.rvs.api.service;

import com.rvs.api.model.DTOs.NewsArticleDTO;
import com.rvs.api.model.NewsArticle;
import com.rvs.api.repository.NewsArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class NewsArticleService {

    private final NewsArticleRepository newsRepository;

    public NewsArticleService(NewsArticleRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


    @Transactional(readOnly = true)
    public List<NewsArticle> getAll(){
        return newsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public NewsArticle getById(UUID id){
        return newsRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Article with id %s was not found".formatted(id)));
    }

    @Transactional(readOnly = true)
    public List<NewsArticle> getLastThree() {
        return newsRepository.findTop3ByOrderByDateDesc();
    }

    public NewsArticle saveArticle(NewsArticleDTO articleDTO){
        return newsRepository.save(articleDTO.mapToArticle());
    }

    public void deleteById(UUID id){
        if (!newsRepository.existsById(id)) throw new NoSuchElementException("Article with id %s was not found".formatted(id));
        newsRepository.deleteById(id);
    }
}
