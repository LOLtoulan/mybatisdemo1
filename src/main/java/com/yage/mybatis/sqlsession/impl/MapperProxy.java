package com.yage.mybatis.sqlsession.impl;

import com.yage.mybatis.cfg.Mapper;
import com.yage.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @Author LOL_toulan
 * @Time 2020/1/28 22:02
 * @Message
 */
public class MapperProxy implements InvocationHandler {

    // 因为我们的mapper类中定义了需要执行的sql语句
    // 而且我们还定义了我们dao接口的全限定类名
    // 我们需要获得全限定类名
    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.connection = connection;
        this.mappers = mappers;
    }

    /**
     * 用于对象方法进行增强，我们说的增强其实就是调用selectList方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //获取方法名
        String methodName = method.getName();

        //获取方法名所在的类
        String classNmae = method.getDeclaringClass().getName();
        //组合Mapper中的key
        String key = classNmae + "." + methodName;
        //获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        //判断是否有mapper
        if (mapper == null) {
            throw  new IllegalArgumentException("传入参数有误");
        }
        // 调用工具类执行查询所有
        // 传入一个Connection对象
        return new Executor().selectList(mapper,  connection);
    }

}
