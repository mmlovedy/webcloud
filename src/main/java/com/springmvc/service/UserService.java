package com.springmvc.service;

import com.springmvc.model.User;

import java.util.List;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: UserService
 * @Package com.springmvc.service
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/5 上午10:45
 */

public interface UserService {

    public int insertUser(User user);

    public List<User> queryUserInfo();
}
