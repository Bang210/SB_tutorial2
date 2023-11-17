package com.ll.sb_tutorial2.domain.article.controller;

import com.ll.sb_tutorial2.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    private final List<Article> articles = new ArrayList<>();
    private int articleCount = 1;

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @PostMapping("/article/doWrite")
    @ResponseBody
    RsData doWrite(
            String title,
            String body
    ) {
        articles.add(new Article(articleCount, title, body));
        articleCount++;

        RsData<Article> rs = new RsData<>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(articles.getLast().getId()),
                articles.getLast()
        );

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(
            String title,
            String body
    ) {
        return articles.getLast();
    }
}

@AllArgsConstructor
@Data
class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;
}