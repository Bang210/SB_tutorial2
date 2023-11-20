package com.ll.sb_tutorial2.domain.article.article.repository;

import com.ll.sb_tutorial2.domain.article.article.entity.Article;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
@Data
public class ArticleRepository {
    public final List<Article> articles = new ArrayList<>() {{
        add(new Article(1L, "제목1", "내용1"));
        add(new Article(2L, "제목2", "내용2"));
    }};

    public void save(Article article) {
        if (article.getId() == null) {
            article.setId(articles.size() + 1L);
        }
        articles.add(article);
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
        if (!articles.isEmpty()) {
            IntStream.range(0, articles.size())
                    .forEach(i -> articles.get(i).setId((long) i + 1));
        }
    }


}
