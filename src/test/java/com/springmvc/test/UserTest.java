package com.springmvc.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmvc.service.AddressService;
import com.springmvc.service.AliToolsService;
import com.springmvc.service.UserService;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: UserTest
 * @Package com.springmvc.test
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/5 上午10:58
 */

public class UserTest {

    private UserService userService;

    private AddressService addressService;

    private AliToolsService aliTools;

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-context.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        //userService = (UserService) context.getBean("userServiceImpl");
        addressService = (AddressService)context.getBean("addressServiceImp");
//        aliTools = (AliToolsService)context.getBean("aliToolsServiceImpl");
    }

   /* @Test
    public void addUser(){
        User user = new User();
        user.setNickname("你好");
        user.setState(2);
        System.out.println(userService.insertUser(user));
    } */

   @Test
   public void createShrIndex() throws IOException {
       addressService.init4LAddress();
   }
  /* @Test
   public void getTaobao4Address(){
       aliTools.getTaobao4Address();
   }*/
}
