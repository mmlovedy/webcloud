package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.District;
import com.springmvc.model.Street;

public interface DistrictDao {
    /** 插入4级地址 **/
    int insert(Street street);
    /** 查询4级地址 **/
    List<Street> selectAllStreets();

    List<District> selectAllDistric();

    List<District> selectAllProvince();

    List<District> selectDistByParent(District district);


}