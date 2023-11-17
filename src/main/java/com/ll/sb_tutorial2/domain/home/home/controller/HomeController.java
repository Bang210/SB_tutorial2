package com.ll.sb_tutorial2.domain.home.home.controller;

import com.ll.sb_tutorial2.domain.home.home.tester.Tester;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/test2")
    @ResponseBody
    Tester showTest2(@RequestParam(defaultValue = "default") String v1,
                     @RequestParam(defaultValue = "12") int v2) {
        return new Tester(v1, v2);
    }

    @GetMapping("/test3")
    String showTest3(Model model) {
        model.addAttribute("val1", "hi");
        model.addAttribute("val2", "daengsol");
        return "test3";
    }

}
