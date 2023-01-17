package com.runninggo.toy.service;

import com.runninggo.toy.dao.PlaceDao;
import com.runninggo.toy.domain.PlaceDto;
import com.runninggo.toy.myinfo.MyInfo;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PlaceServiceImpl implements PlaceService {

    PlaceDao placeDao;
    MyInfo myInfo;

    public PlaceServiceImpl(MyInfo myInfo, PlaceDao placeDao) {
        this.myInfo = myInfo;
        this.placeDao = placeDao;
    }

    @Override
    public List<String> getSubwayInfo(String subwayName) throws Exception {
        List<String> lineList = new ArrayList<>();
        String lineNum = "";

        try {
            String encodeSubwayName = URLEncoder.encode(subwayName, "UTF-8");
            log.info("encodeSubwayName = {}, decodeSubwayName = {}", encodeSubwayName, URLDecoder.decode(encodeSubwayName));

            URL url = new URL("http://openapi.seoul.go.kr:8088/" +
                    myInfo.seoulApiKey + "/json/SearchInfoBySubwayNameService/1/5/" + encodeSubwayName + "/");

            //InputStreamReader : 바이트 단위 데이터를 문자(character) 단위 데이터로 처리할 수 있도록 변환해준다.
            //BufferedReader : Buffer(버퍼)를 통해 입력받은 문자를 쌓아둔 뒤 한 번에 문자열처럼 보내버리는 것.
            //readLine :  한 줄 전체를(공백 포함) 읽어 String으로 return
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String result = bf.readLine();
            log.info("url StringType result = {}", result);

            JSONObject jObject = new JSONObject(result); //json 객체
            JSONObject sibsns = jObject.getJSONObject("SearchInfoBySubwayNameService"); //받아온 json데이터 중 최상위 object
            JSONArray row = sibsns.getJSONArray("row");

            // 베열 출력
            for (int i = 0; i < row.length(); i++) {
                JSONObject obj = row.getJSONObject(i);
                lineList.add(obj.getString("LINE_NUM"));
                log.info("LINE_NUM = {}", lineList.get(i));
            }
        } catch (Exception e) {
            log.error("error = {}", e.getMessage());
            e.printStackTrace();
            lineList.add("error");
            return lineList;
        }
        return lineList;
    }

    @Override
    public void postsInsert(PlaceDto placeDto) throws Exception {
        placeDao.postsInsert(placeDto);
    }
}
