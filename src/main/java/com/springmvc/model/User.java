package com.springmvc.model;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: User
 * @Package com.springmvc.model
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/5 上午10:42
 */
public class User
{
    private int id;
    private int state;
    private String nickname;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
