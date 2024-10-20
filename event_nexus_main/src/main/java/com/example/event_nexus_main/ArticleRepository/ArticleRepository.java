

package com.example.event_nexus_main.ArticleRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.event_nexus_main.model.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    // Fetch the latest two articles ordered by date (or some other field like ID)
    @Query("SELECT a FROM Article a ORDER BY a.createdAt DESC")
    List<Article> findTop2ByOrderByCreatedAtDesc();
}

