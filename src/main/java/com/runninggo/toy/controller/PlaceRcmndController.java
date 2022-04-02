package com.runninggo.toy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/place")
public class PlaceRcmndController {

    @GetMapping("/recmndForm")
    public String placeRcmndForm() {
        return "/place/recmndForm";
    }
}
