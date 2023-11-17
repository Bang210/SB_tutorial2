package com.ll.sb_tutorial2.domain.article.article.service;

import com.ll.sb_tutorial2.domain.article.article.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    public final List<Article> articles = new ArrayList<>();
    private int idCount = 1;
    public void write(String title, String body) {
        Article article = new Article(idCount, title, body);
        articles.add(article);
        idCount++;
    }

    public Article findLastArticle() {
        return articles.getLast();
    }

    public List<Article> findAll() {
        return articles;
    }
}
