package com.runninggo.toy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Controller
@RequestMapping("/place")
public class PlaceRcmndController {

    @GetMapping("/recmndForm")
    public String placeRcmndForm() {
        return "/place/recmndForm";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "/place/writeForm";
    }

    @ResponseBody
//    @GetMapping("/subway_search")
    @RequestMapping(value = "/subway_search", produces = "application/json; charset=utf8")
    public String idCheck(String subwayName) {
        String key = "62444d75596b696d34334244737869";
        String result = "";
        String query = "";
        try {
            query = URLEncoder.encode(subwayName, "UTF-8");

            URL url = new URL("http://openapi.seoul.go.kr:8088/" +
                    key + "/json/SearchInfoBySubwayNameService/1/5/" + query + "/");

            System.out.println(url);
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = bf.readLine();

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
