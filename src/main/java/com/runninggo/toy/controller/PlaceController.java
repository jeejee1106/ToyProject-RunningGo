package com.runninggo.toy.controller;

import com.runninggo.toy.domain.PlaceDto;
import com.runninggo.toy.service.PlaceService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.constraints.Null;

@Controller
@RequestMapping("/place")
@Slf4j
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
    public String postsInsert(@Valid PlaceDto placeDto, Errors errors) throws Exception{

        if(placeDto.getDistance() == null){
            placeDto.setDistance(0.0);
        }
        System.out.println("placeDto = " + placeDto.getDistance());
        if (errors.hasErrors()) {
//            log.error("PlaceDto 유효성 검증 에러 = " + errors);
            return "/place/writeForm";
        }
        placeService.postsInsert(placeDto);
        return "/place/recmndForm";
    }

    @ResponseBody
    @GetMapping(value = "/subway_search", produces = "application/json; charset=utf8")
    public String getSubwayInfo(String subwayName) throws Exception{
        return placeService.getSubwayInfo(subwayName);
    }
}
