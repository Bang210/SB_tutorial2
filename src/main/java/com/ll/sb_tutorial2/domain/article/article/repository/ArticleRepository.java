package com.ll.sb_tutorial2.domain.article.article.repository;

import com.ll.sb_tutorial2.domain.article.article.entity.Article;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class ArticleRepository {
    public final List<Article> articles = new ArrayList<>();
    private Long idCount = 1L;

    public void save(Article article) {
        articles.add(article);
        if (article.getId() == null) {
            article.setId(idCount);
        }
        idCount++;
    }

    public Article getLastArticle() {
        return articles.getLast();
    }
}
