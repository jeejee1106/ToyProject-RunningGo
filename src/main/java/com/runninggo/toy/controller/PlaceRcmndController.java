package com.runninggo.toy.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        String lineNum = "";

        try {
            String query = URLEncoder.encode(subwayName, "UTF-8");

            URL url = new URL("http://openapi.seoul.go.kr:8088/" +
                    key + "/json/SearchInfoBySubwayNameService/1/5/" + query + "/");

            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String result = bf.readLine();
            System.out.println(result);

            JSONObject jObject = new JSONObject(result); //json 객체

            JSONObject sibsns = jObject.getJSONObject("SearchInfoBySubwayNameService"); //최상위 object

//            JSONObject RESULT = sibsns.getJSONObject("RESULT");
//            String CODE = RESULT.getString("CODE");
//            int list_total_count = sibsns.getInt("list_total_count");
//            System.out.println(CODE);
//            System.out.println(list_total_count);

            JSONArray row = sibsns.getJSONArray("row");

            // 베열 출력
            for (int i = 0; i < row.length(); i++) {
                JSONObject obj = row.getJSONObject(i);
                lineNum += "#" + obj.getString("LINE_NUM");

                System.out.println("LINE_NUM(" + i + "): " + lineNum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return lineNum;
    }
}
