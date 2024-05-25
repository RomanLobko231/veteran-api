package com.rvs.api.repository;

import com.rvs.api.model.Document;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DocumentsRepository extends JpaRepository<Document, UUID> {

    @EntityGraph(attributePaths = {"fileData"})
    @Query("SELECT d FROM Document d WHERE d.id = :id")
    Optional<Document> findFullDocumentById(@Param("id") UUID id);
}
