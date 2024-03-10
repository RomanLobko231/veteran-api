package com.rvs.api.repository;

import com.rvs.api.model.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticle, UUID> {

    List<NewsArticle> findTop3ByOrderByDateDesc();

}
