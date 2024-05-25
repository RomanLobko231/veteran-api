package com.rvs.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.Type;

import java.sql.Types;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonProperty(value = "file")
    @Column(name = "file_data", columnDefinition = "bytea")
    @Basic(fetch = FetchType.LAZY)
    private byte[] fileData;

    @Column(name = "title")
    @JsonProperty(value = "title")
    @NotBlank(message = "Title should not be empty")
    @Size(max = 500, message = "Title should not exceed 500 characters")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    @JsonProperty(value = "description")
    private String description;

    @Column(name = "mime_type")
    @JsonProperty(value = "mime_type")
    private String mimeType;

    @CreationTimestamp(source = SourceType.DB)
    private Instant date;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @JsonIgnore(value = true)
    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Document() {
    }

    public Document(byte[] fileData, String title, String description, String mimeType) {
        this.fileData = fileData;
        this.title = title;
        this.description = description;
        this.mimeType = mimeType;
    }
}
