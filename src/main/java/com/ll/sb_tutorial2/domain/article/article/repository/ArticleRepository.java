package com.ll.sb_tutorial2.domain.article.article.repository;

import com.ll.sb_tutorial2.domain.article.article.entity.Article;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Data
public class ArticleRepository {
    public final List<Article> articles = new ArrayList<>() {{
        add(new Article(1L, "제목1", "내용1"));
        add(new Article(2L, "제목2", "내용2"));
        add(new Article(3L, "제목3", "내용3"));
    }};

    public void save(Article article) {
        articles.add(article);
        if (article.getId() == null) {
            article.setId(articles.size() + 1L);
        }
    }

    public Article getLastArticle() {
        return articles.getLast();
    }

    public Optional<Article> findById(long id) {
        return articles.stream()
                .filter(article -> article.getId() == id)
                .findFirst();
    }

    public void delete(long id) {
        articles.removeIf(article -> article.getId() == id);
    }


}
