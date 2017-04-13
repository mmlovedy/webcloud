package com.springmvc;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 刘德云
 * @version V1.0
 * @Title: FIleUtils
 * @Package com.springmvc
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @date 2017/4/12 下午11:33
 */
public class FIleUtils {
    public static void appendMethodB(String fileName, String content) {
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
