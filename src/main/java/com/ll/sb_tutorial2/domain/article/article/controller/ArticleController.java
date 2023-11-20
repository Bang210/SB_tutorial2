package com.ll.sb_tutorial2.domain.article.article.controller;

import com.ll.sb_tutorial2.domain.article.article.entity.Article;
import com.ll.sb_tutorial2.domain.article.article.service.ArticleService;
import com.ll.sb_tutorial2.global.rq.Rq;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Validated
public class ArticleController {
    private final ArticleService articleService;
    private final Rq rq;


    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    String write(
            @NotBlank String title,
            @NotBlank String body
    ) {
        articleService.write(title, body);

        return rq.redirect("/article/list", "%d번 게시물이 생성되었습니다.".formatted(articleService.findLastArticle().getId()));

    }

    @GetMapping("/article/list")
    String showList(Model model) {

        List<Article> articles = articleService.findAll();

        model.addAttribute("articles", articles);

        return "article/list";
    }

    @GetMapping("/article/detail/{id}")
    String showDetail(Model model, @PathVariable long id) {
        Article article = articleService.findById(id).get();

        model.addAttribute("article", article);

        return "article/detail";
    }

    @GetMapping("/article/delete/{id}")
    String delete(@PathVariable long id) {

        articleService.delete(id);

        return rq.redirect("/article/list", "%d번 게시물이 삭제되었습니다.".formatted(id));
    }

    @GetMapping("/article/modify/{id}")
    String showModify(@PathVariable long id, Model model) {
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);
        return "article/modify";
    }

    @PostMapping("/article/modify/{id}")
    String modify(
            @PathVariable long id,
            @NotBlank String title,
            @NotBlank String body
    ) {
        articleService.modify(id, title, body);

        return rq.redirect("/article/list", "%d번 게시물이 수정되었습니다.".formatted(articleService.findLastArticle().getId()));
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

