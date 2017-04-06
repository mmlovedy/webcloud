package com.springmvc.test;

import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-context.xml"
                ,"classpath:conf/spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setNickname("你好");
        user.setState(2);
        System.out.println(userService.insertUser(user));
    }
}
