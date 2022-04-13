package com.runninggo.toy.controller;

import com.runninggo.toy.service.PlaceRecmndService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/place")
public class PlaceRcmndController {

    @Autowired
    PlaceRecmndService placeRecmndService;

    @GetMapping("/recmndForm")
    public String placeRcmndForm() {
        return "/place/recmndForm";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "/place/writeForm";
    }

    @ResponseBody
    @GetMapping(value = "/subway_search", produces = "application/json; charset=utf8")
    public String getSubwayInfo(String subwayName) throws Exception{
        return placeRecmndService.getSubwayInfo(subwayName);
    }
}
