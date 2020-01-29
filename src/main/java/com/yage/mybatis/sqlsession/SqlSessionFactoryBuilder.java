package com.yage.mybatis.sqlsession;

import com.yage.mybatis.cfg.Configuration;
import com.yage.mybatis.sqlsession.impl.SqlSessionFactoryImpl;
import com.yage.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @Author LOL_toulan
 * @Time 2020/1/28 18:30
 * @Message
 *
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {


    public SqlSessionFactory build(InputStream in) {

        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);

        return new SqlSessionFactoryImpl(cfg);
    }

}
