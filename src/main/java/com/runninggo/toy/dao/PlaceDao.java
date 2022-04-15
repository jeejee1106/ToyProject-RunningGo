package com.runninggo.toy.dao;

import com.runninggo.toy.domain.PlaceDto;

public interface PlaceDao {
    int postsInsert(PlaceDto placeDto) throws Exception;
}
