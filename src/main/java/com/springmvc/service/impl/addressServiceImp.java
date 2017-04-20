package com.springmvc.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.support.json.JSONUtils;
import com.springmvc.HttpUtils;
import com.springmvc.dao.DistrictDao;
import com.springmvc.dao.WaybillDao;
import com.springmvc.model.Street;
import com.springmvc.model.Waybill;
import com.springmvc.service.AddressService;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: YDServiceImp
 * @Package com.springmvc.service.impl
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/11 下午11:23
 */
@Service
public class addressServiceImp implements AddressService {
    @Autowired
    WaybillDao waybillDao;

    @Autowired
    DistrictDao districtDao;

    private final String URL = "http://localhost:9200/hydata/yd";

//    private final String URL_ADDRESS = "http://localhost:9200/address/4level";

    private final String URL_ADDRESS = "http://172.23.72.1:9200/address/4level";

    private final String URL_SEARCH = "http://localhost:9200/hydata/yd/_search";

//    private final String URL_ADDRESS_SEARCH = "http://localhost:9200/address/4level/_search";

    private final String URL_ADDRESS_SEARCH = "http://172.23.72.1:9200/address/4level/_search";



    RestTemplate restTemplate = new RestTemplate();

    @Override
    public void initYD() {
        List<Waybill> waybillList = waybillDao.selectYd();


        RestTemplate restTemplate = HttpUtils.getHttpTemplet();
        //restTemplate.put("http://localhost:9200/hydata/yd/F9401878","{ \"YDBH\":\"F9401878\",\"SHRDZ\":\"广东韶关武江区四川资阳雁江区四川省资阳市雁江区四川省资阳市雁江区侯家坪工业园\"}");
        HttpHeaders headers =HttpUtils.getHeaders();
        String url ;
        String json;
        String str;
        for(Waybill waybill :waybillList){
            //url = URL + waybill.getYdbh();
            json = "{ \"YDBH\":\""+waybill.getYdbh()+"\",\"SHRDZ\":\""+waybill.getShrdz()+"\"}";
            System.out.println(json);
            str = restTemplate.postForObject(URL,new HttpEntity<String>(json, headers),String.class);
            //restTemplate.put(url,json);
            //restTemplate.delete(url);
            System.out.println(str);
        }
        System.out.println(restTemplate.getForObject(URL_SEARCH,String.class));
    }

    public void init4LAddress() {
        List<Street> streets = districtDao.selectAllStreets();
        RestTemplate restTemplate = HttpUtils.getHttpTemplet();
        HttpHeaders headers =HttpUtils.getHeaders();
        String json;
        String str;
        int i = 0;
        for(Street street :streets){
            json = JSON.toJSONString(street);
            str = restTemplate.postForObject(URL_ADDRESS,new HttpEntity<String>(json, headers),String.class);
            System.out.println(i++);
        }
        System.out.println(restTemplate.getForObject(URL_ADDRESS_SEARCH,String.class));
    }
}
