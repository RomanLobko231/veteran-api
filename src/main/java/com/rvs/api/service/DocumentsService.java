package com.rvs.api.service;

import com.rvs.api.model.DTOs.DocumentDisplayDTO;
import com.rvs.api.model.DTOs.DocumentDownloadDTO;
import com.rvs.api.model.Document;
import com.rvs.api.repository.DocumentsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DocumentsService {

    private final DocumentsRepository documentsRepository;

    public DocumentsService(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    public List<DocumentDisplayDTO> getAll(){
        return documentsRepository
                .findAll()
                .stream()
                .map(DocumentDisplayDTO::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Document getDocumentById(UUID id){
        return documentsRepository
                .findFullDocumentById(id)
                .orElseThrow(() -> new NoSuchElementException("A document with id %s was not found".formatted(id)));
    }

    public Document save(Document document){
        return documentsRepository.save(document);
    }

    public void deleteById(UUID id){
       if (!documentsRepository.existsById(id)) throw new NoSuchElementException("A document with id %s was not found".formatted(id));
       documentsRepository.deleteById(id);
    }

    @Transactional(readOnly = true)

    public DocumentDownloadDTO getDocumentForDownloadById(UUID id) {
        if (!documentsRepository.existsById(id)) throw new NoSuchElementException("A document with id %s was not found".formatted(id));
        return documentsRepository
                .findById(id)
                .map(DocumentDownloadDTO::mapToDTO)
                .orElseThrow(() -> new NoSuchElementException("A document with id %s was not found".formatted(id)));
    }
}
