package com.springmvc.controller;

import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: UserController
 * @Package com.springmvc.controller
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/5 上午11:27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/insert")
    public int insertUser(User user){
        return userService.insertUser(user);
    }

   /* @RequestMapping("/query")
    public String getUserInfo() throws IOException {
        return new ObjectMapper().writeValueAsString(userService.queryUserInfo());
    }*/
   @RequestMapping(value = "/query",produces = {"application/json ; charset=UTF-8 "})
   public List<User> getUserInfo() throws IOException {
       return userService.queryUserInfo();
   }

}
