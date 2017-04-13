package com.springmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: HttpUtils
 * @Package com.springmvc
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/12 上午9:08
 */
public class HttpUtils {
    /**
     * 获取头部
     *
     * @return
     */
    public static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return headers;
    }

    public static RestTemplate getHttpTemplet(){
        StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
        list.add(m);
        RestTemplate restTemplate = new RestTemplate(list);
        return restTemplate;
    }
}
