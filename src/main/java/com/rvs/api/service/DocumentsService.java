package com.rvs.api.service;

import com.rvs.api.model.DTOs.DocumentDisplayDTO;
import com.rvs.api.model.DTOs.DocumentDownloadDTO;
import com.rvs.api.model.Document;
import com.rvs.api.repository.DocumentsRepository;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.pdf.PdfConversion;
import org.docx4j.convert.out.pdf.viaXSLFO.Conversion;
import org.docx4j.fonts.*;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Fonts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DocumentsService {

    private final DocumentsRepository documentsRepository;

    public DocumentsService(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    public List<DocumentDisplayDTO> getAll() {
        return documentsRepository
                .findDocumentsWithoutFileData()
                .stream()
                .map(DocumentDisplayDTO::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Document getDocumentById(UUID id) {
        Document document = documentsRepository
                .findFullDocumentById(id)
                .orElseThrow(() -> new NoSuchElementException("A document with id %s was not found".formatted(id)));
        byte[] pdfBytes = convertDocToPdf(document.getFileData());
        document.setFileData(pdfBytes);
        document.setMimeType("application/pdf");
        return document;
    }


    public Document save(Document document) {
        return documentsRepository.save(document);
    }

    public void deleteById(UUID id) {
        if (!documentsRepository.existsById(id))
            throw new NoSuchElementException("A document with id %s was not found".formatted(id));
        documentsRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public DocumentDownloadDTO getDocumentForDownloadById(UUID id) {
        if (!documentsRepository.existsById(id))
            throw new NoSuchElementException("A document with id %s was not found".formatted(id));
        return documentsRepository
                .findById(id)
                .map(DocumentDownloadDTO::mapToDTO)
                .orElseThrow(() -> new NoSuchElementException("A document with id %s was not found".formatted(id)));
    }

    private byte[] convertDocToPdf(byte[] docxBytes) {
        try {
            InputStream inputStream = new ByteArrayInputStream(docxBytes);
            WordprocessingMLPackage wordMLPackage = Docx4J.load(inputStream);

            String fontDirPath = "resources/fonts";
            Mapper fontMapper = new IdentityPlusMapper();

            File fontDir = new File(fontDirPath);
            if (fontDir.isDirectory()) {
                for (File fontFile : fontDir.listFiles()) {
                    PhysicalFonts.addPhysicalFonts(fontFile.getName(), fontFile.toURI());
                }
            }
            PhysicalFont font = PhysicalFonts.get("timesnrcyrmt");
            fontMapper.put("Times New Roman", font);
            wordMLPackage.setFontMapper(fontMapper);

            ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
            Docx4J.toPDF(wordMLPackage, pdfOutputStream);
            return pdfOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
