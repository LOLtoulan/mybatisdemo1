package com.yage.mybatis.utils;

import com.yage.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @Author LOL_toulan
 * @Time 2020/1/28 22:25
 * @Message
 */
public class DataSourceUtil {

    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        Connection connection = null;
        try {
            Class.forName(cfg.getDriver());
            connection = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
