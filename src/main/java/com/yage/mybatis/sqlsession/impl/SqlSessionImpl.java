package com.yage.mybatis.sqlsession.impl;

import com.yage.mybatis.cfg.Configuration;
import com.yage.mybatis.sqlsession.SqlSession;
import com.yage.mybatis.utils.DataSourceUtil;


import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author LOL_toulan
 * @Time 2020/1/28 21:57
 * @Message
 */
public class SqlSessionImpl implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     *
     * @param daoInterfaceClass dao接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        T t = null;
        try {
             t = (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return t;
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
