package com.rvs.api.repository;

import com.rvs.api.model.DTOs.DocumentDisplayDTO;
import com.rvs.api.model.Document;
import com.rvs.api.service.DocumentsService;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("dev")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DocumentRepositoryTest {

    @Autowired
    DocumentsRepository documentRepository;

    @Test
    public void testLazyLoading() {
        Document newDocument = new Document(new byte[] {1} , "title", "description", "type/type");

        UUID documentId = documentRepository.save(newDocument).getId();
        Optional<Document> optionalDocument = documentRepository.findById(documentId);

        Document document = optionalDocument.get();
        System.out.println(Arrays.toString(document.getFileData()));

        PersistenceUtil jpaUtil = Persistence.getPersistenceUtil();
        assertFalse(jpaUtil.isLoaded(document, "fileData"));

        byte[] fileData = document.getFileData();
        assertTrue(jpaUtil.isLoaded(document, "fileData"));
    }

    @Test
    public void testEagerLoadingWithEntityGraph() {
        byte[] byteArray = new byte[1];
        byteArray[0] = 'b';

        Document newDocument = new Document(byteArray , "title", "description", "type/type");

        UUID documentId = documentRepository.save(newDocument).getId();
        Optional<Document> optionalDocument = documentRepository.findFullDocumentById(documentId);
        assertTrue(optionalDocument.isPresent());

        PersistenceUtil jpaUtil = Persistence.getPersistenceUtil();
        Document document = optionalDocument.get();
        assertTrue(jpaUtil.isLoaded(document, "fileData"));
    }
}
