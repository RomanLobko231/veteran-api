package com.rvs.api.repository;

import com.rvs.api.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentsRepository extends JpaRepository<Document, UUID> {
}
