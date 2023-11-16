package com.ll.sb_tutorial2.domain.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    String showMain() {
        return "Main page";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout() {
        return "연습용 프로젝트입니다.";
    }

    @GetMapping("/test1")
    @ResponseBody
    String showTest1(@RequestParam(defaultValue = "0") int a,
                  @RequestParam(defaultValue = "0") int b) {
        return "계산결과: %d".formatted(a + b);
    }

}
