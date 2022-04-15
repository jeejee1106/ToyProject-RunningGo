package com.runninggo.toy.service;

import com.runninggo.toy.domain.PlaceDto;

public interface PlaceService {
    String getSubwayInfo(String subwayName) throws Exception;
    void postsInsert(PlaceDto placeDto) throws Exception;
}
