package com.ll.sb_tutorial2.domain.article.article.controller;

import com.ll.sb_tutorial2.domain.article.article.entity.Article;
import com.ll.sb_tutorial2.domain.article.article.service.ArticleService;
import com.ll.sb_tutorial2.global.rq.Rq;
import com.ll.sb_tutorial2.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final Rq rq;


    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData write(
            String title,
            String body
    ) {
        if (title == null || title.trim().isEmpty()) {
            return new RsData<>("F-1", "제목을 입력해주세요.");
        }
        if (body == null || body.trim().isEmpty()) {
            return new RsData<>("F-2", "내용을 입력해주세요.");
        }
        articleService.write(title, body);

        RsData<Article> rs = new RsData<>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(articleService.findLastArticle().getId()),
                articleService.findLastArticle()
        );

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(
            String title,
            String body
    ) {
        return articleService.findLastArticle();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articleService.findAll();
    }
}

