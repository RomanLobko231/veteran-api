package com.rvs.api.model.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rvs.api.model.Document;

import java.time.Instant;
import java.util.UUID;

public class DocumentDisplayDTO {

    @JsonProperty(value = "id")
    private UUID id;

    @JsonProperty(value = "title")

    private String title;

    @JsonProperty(value = "date")

    private Instant date;

    public DocumentDisplayDTO(UUID id, String title, Instant date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public static DocumentDisplayDTO mapToDTO(Document document){
        return new DocumentDisplayDTO(document.getId(), document.getTitle(), document.getDate());
    }
}
