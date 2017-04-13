package com.springmvc.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springmvc.HttpUtils;
import com.springmvc.dao.DistrictDao;
import com.springmvc.model.District;
import com.springmvc.model.Street;
import com.springmvc.service.AliToolsService;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: AliToolsImpl
 * @Package com.springmvc.service.impl
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/12 上午9:07
 */
@Service
public class AliToolsServiceImpl implements AliToolsService {

    @Autowired
    DistrictDao districtDao;

    private static final String URL = "https://lsp.wuliu.taobao.com/locationservice/addr/" +
            "output_address_town_array.do?l1={0}&l2={1}&l3={2}&lang=zh-S&_ksTS={3}&callback=jsonp{4}";
    @Override
    public void getTaobao4Address() {
        String realUrl ;
        RestTemplate restTemplate = HttpUtils.getHttpTemplet();
        HttpHeaders headers = HttpUtils.getHeaders();
        realUrl = MessageFormat.format(URL,"","","") ;
        List<District> districts = districtDao.selectAllDistric();
        Map<String,List<District>> districtCache = new HashMap<String, List<District>>();
        for (District district :districts){
            List<District> list = districtCache.get(district.getParentDistrictCode());
            if(list !=null){
                districtCache.remove(district.getParentDistrictCode());
                list.add(district);
                districtCache.put(district.getParentDistrictCode(),list);
            }else {
                list = new ArrayList<District>();
                list.add(district);
                districtCache.put(district.getParentDistrictCode(),list);
            }
        }
        //查询所有省份
        List<District> provinces = districtDao.selectAllProvince();
        String response ;
        String sp = "\\],\\[";
        List<Street> streets = new ArrayList<Street>();
        String detailAddress ;
        String detailAddressPinyin;
        String address ;
        String addressPinyin;
        FileWriter writer = null;
        FileWriter erroWriter = null;
        try {
            writer = new FileWriter("/Users/dytt/Downloads/streets.txt",true);
            erroWriter = new FileWriter("/Users/dytt/Downloads/streets.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        for (District province : provinces){
            List<District> citys = districtCache.get(province.getDistrictCode());
            if(citys == null){
                continue;
            }
            for(District city :citys ){
                int i =  new Random().nextInt(1000);
                List<District> Areas = districtCache.get(city.getDistrictCode());
                if(Areas == null){
                    continue;
                }
                int t=0;
                for(District area : Areas){
                    try {
                            realUrl = MessageFormat.format(URL,province.getDistrictCode(),city.getDistrictCode(),
                                    area.getDistrictCode(),new Date().getTime()+"_"+i,i);
                            response = restTemplate.getForObject(realUrl,String.class);
                            /**如果访问失败则继续访问，直到10次后放弃  **/
                            while (response.indexOf("result:[]")>-1 && t < 10){
                                realUrl = MessageFormat.format(URL,province.getDistrictCode(),city.getDistrictCode(),
                                        area.getDistrictCode(),new Date().getTime()+"_"+i,i);
                                response = restTemplate.getForObject(realUrl,String.class);
                                t++;
                            }
                            System.out.println(realUrl);
                            String result = response.substring(response.indexOf("[[")+2,response.indexOf("]]}"));
                            System.out.println(result);
                            String[] resultList = result.split(sp);
                            for (String bean : resultList){
                                bean = bean.replaceAll("\'","");
                                String[] strs = bean.split(",");
                                addressPinyin = strs[3].replaceAll(" ","").toUpperCase();
                                detailAddress = province.getDistrictName()+city.getDistrictName()+area.getDistrictName()+strs[1];
                                detailAddressPinyin = province.getPinyin()+city.getPinyin()+area.getPinyin()+addressPinyin;
                                Street street = new Street(province.getDistrictCode(),city.getDistrictCode(),area.getDistrictCode(),
                                        strs[0],detailAddress,detailAddressPinyin,strs[1],addressPinyin);
                                streets.add(street);
                                districtDao.insert(street);
                                try {
                                    writer.append(province.getDistrictCode()+","+province.getDistrictName()+","
                                            +city.getDistrictCode()+","+city.getDistrictName()+","
                                            +strs[0]+","+strs[1]+","+addressPinyin+"\r\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    try {
                                        writer.close();
                                    } catch (IOException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            }

                            response = null;
                        }catch (Exception e){
                        try {
                            erroWriter.append(province.getDistrictCode()+","+province.getDistrictName()+","
                                    +city.getDistrictCode()+","+city.getDistrictName()+","+area.getDistrictCode() +"," +area.getDistrictName());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    }

                }

        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertStreets(Street street) {
        districtDao.insert(street);
    }
}
