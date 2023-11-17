package com.ll.sb_tutorial2.domain.article.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Article {
    private long id;
    private String title;
    private String body;
}
