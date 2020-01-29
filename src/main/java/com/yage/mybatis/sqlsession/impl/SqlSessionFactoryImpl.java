package com.yage.mybatis.sqlsession.impl;

import com.yage.mybatis.cfg.Configuration;
import com.yage.mybatis.sqlsession.SqlSession;
import com.yage.mybatis.sqlsession.SqlSessionFactory;

/**
 * @Author LOL_toulan
 * @Time 2020/1/28 21:53
 * @Message
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {

    private Configuration cfg;

    public SqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库的对象
     *
     * @return
     */
    @Override
    public SqlSession openSession() {

        return new SqlSessionImpl(cfg);
    }
}
