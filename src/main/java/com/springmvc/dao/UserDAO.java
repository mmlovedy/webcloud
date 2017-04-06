package com.springmvc.dao;

import com.springmvc.model.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: UserDAO
 * @Package com.springmvc.dao
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/5 上午10:43
 */
public interface UserDAO {
    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);

    public List<User> queryUsers();

}
