package com.runninggo.toy.service;

import com.runninggo.toy.myinfo.MyInfo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class PlaceRecmndServiceImpl implements PlaceRecmndService {

    MyInfo myInfo = new MyInfo();
    final String KEY = myInfo.seoulApiKey;

    @Override
    public String getSubwayInfo(String subwayName) throws Exception {
        String lineNum = "";

        try {
            String encodeSubwayName = URLEncoder.encode(subwayName, "UTF-8");

            URL url = new URL("http://openapi.seoul.go.kr:8088/" +
                    KEY + "/json/SearchInfoBySubwayNameService/1/5/" + encodeSubwayName + "/");

            //InputStreamReader : 바이트 단위 데이터를 문자(character) 단위 데이터로 처리할 수 있도록 변환해준다.
            //BufferedReader : Buffer(버퍼)를 통해 입력받은 문자를 쌓아둔 뒤 한 번에 문자열처럼 보내버리는 것.
            //readLine :  한 줄 전체를(공백 포함) 읽어 String으로 return
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String result = bf.readLine();
//            System.out.println(result);

            JSONObject jObject = new JSONObject(result); //json 객체
            JSONObject sibsns = jObject.getJSONObject("SearchInfoBySubwayNameService"); //최상위 object
            JSONArray row = sibsns.getJSONArray("row");

            // 베열 출력
            for (int i = 0; i < row.length(); i++) {
                JSONObject obj = row.getJSONObject(i);
                lineNum += "#" + obj.getString("LINE_NUM");
//                System.out.println("LINE_NUM(" + i + "): " + lineNum);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return lineNum;
    }
}
