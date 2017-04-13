package com.springmvc.service.impl;

import com.springmvc.dao.UserDAO;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: UserServiceImpl
 * @Package com.springmvc.service.impl
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/5 上午10:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }

    public List<User> queryUserInfo() {
        return userDAO.queryUsers();
    }

}
