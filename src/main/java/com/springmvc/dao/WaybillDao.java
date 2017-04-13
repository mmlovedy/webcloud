package com.springmvc.dao;

import com.springmvc.model.Waybill;

import java.util.List;

public interface WaybillDao {
    int insert(Waybill record);

    int insertSelective(Waybill record);

    List<Waybill>selectYd();
}