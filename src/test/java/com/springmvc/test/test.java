package com.springmvc.test;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: test
 * @Package com.springmvc.test
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/13 上午9:43
 */
public class test {
    public static void main(String[] args) {
        String str = "'110101001','东华门街道','110101','dong hua men jie dao'";
        System.out.print(str.replaceAll("\'",""));
    }
}
