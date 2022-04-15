package com.runninggo.toy.controller;

import com.runninggo.toy.domain.PlaceDto;
import com.runninggo.toy.service.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @GetMapping("/recmndForm")
    public String placeRcmndForm() {
        return "/place/recmndForm";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "/place/writeForm";
    }

    @PostMapping("/recmnd")
    public String postsInsert(PlaceDto placeDto) throws Exception{
        placeService.postsInsert(placeDto);
        return "/place/recmndForm";
    }

    @ResponseBody
    @GetMapping(value = "/subway_search", produces = "application/json; charset=utf8")
    public String getSubwayInfo(String subwayName) throws Exception{
        return placeService.getSubwayInfo(subwayName);
    }
}
