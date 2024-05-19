package com.rvs.api.model.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rvs.api.model.Document;

public class DocumentDownloadDTO {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "mime_type")
    private String mimeType;

    @JsonProperty(value = "file")
    private byte[] fileData;

    public DocumentDownloadDTO(String title, String mimeType, byte[] fileData) {
        this.title = title;
        this.mimeType = mimeType;
        this.fileData = fileData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public static DocumentDownloadDTO mapToDTO(Document document){
        return new DocumentDownloadDTO(document.getTitle(), document.getMimeType(), document.getFileData());
    }
}
