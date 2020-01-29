package com.yage.mybatis.io;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author LOL_toulan
 * @Time 2020/1/28 15:50
 * @Message
 */
public class Resources {

    /**
     * 根据传入的参数获取一个字节输入流
     * @param filepath
     * @return
     */
    public static InputStream getResourceAsStream(String filepath) throws FileNotFoundException {

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(filepath);

        return is;
    }
}
