package com.rvs.api.controller;

import com.rvs.api.model.DTOs.DocumentDisplayDTO;
import com.rvs.api.model.DTOs.DocumentDownloadDTO;
import com.rvs.api.model.Document;
import com.rvs.api.service.DocumentsService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    private final DocumentsService documentsService;

    public DocumentsController(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }

    @PostMapping()
    ResponseEntity<Document> createNewDocument(
            @RequestParam(value = "file") MultipartFile uploadedFile,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "description", required = false) String description
    ) {
        Document newDocument = new Document();
        try {
            newDocument.setTitle(title);
            newDocument.setDescription(description);
            newDocument.setFileData(uploadedFile.getBytes());
            newDocument.setMimeType(uploadedFile.getContentType());
        } catch (IOException e) {
            throw new RuntimeException("Could not save the file with the name: %s".formatted(uploadedFile.getOriginalFilename()), e);
        }
        return ResponseEntity.ok(documentsService.save(newDocument));
    }

    @GetMapping("/display")
    ResponseEntity<List<DocumentDisplayDTO>> getAll(){
        return ResponseEntity.ok(documentsService.getAll());
    }

    @GetMapping("/{id}/download")
    ResponseEntity<DocumentDownloadDTO> downloadDocumentById(@PathVariable UUID id){
        return ResponseEntity.ok(documentsService.getDocumentForDownloadById(id));
    }

    @GetMapping("/download/{id}")
    ResponseEntity<byte[]> downloadDocument(@PathVariable UUID id){
        DocumentDownloadDTO document = documentsService.getDocumentForDownloadById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getTitle() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, document.getMimeType())
                .body(document.getFileData());
    }

    @GetMapping("/{id}")
    ResponseEntity<Document> getDocumentById(@PathVariable UUID id){
        return ResponseEntity.ok(documentsService.getDocumentById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id){
        documentsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
