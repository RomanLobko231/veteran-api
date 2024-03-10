package com.rvs.api.model.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rvs.api.model.NewsArticle;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewsArticleDTO {

    @JsonProperty(value = "title")
    @NotBlank(message = "Title should not be empty")
    @Size(max = 300, message = "Title should not exceed 300 characters")
    private String title;

    @JsonProperty(value = "content")
    @NotBlank(message = "Article content should not be empty")
    private String content;


    public NewsArticleDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsArticle mapToArticle(){
        return new NewsArticle(null, title, content);
    }
}
