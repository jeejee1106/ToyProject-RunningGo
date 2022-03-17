package com.runninggo.toy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

//    @GetMapping("/")
//    public String index(Model m) {
//        m.addAttribute("data", "안녕~hello~");
//        return "/layout/main";
//    }

    @GetMapping("/login")
    public String login(Model m) {
        m.addAttribute("data", "로그인하실건가요?");
        return "/login/login";
    }
}
