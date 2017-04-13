package com.springmvc.dao;

import com.springmvc.model.yd;

public interface ydMapper {
    int insert(yd record);

    int insertSelective(yd record);
}