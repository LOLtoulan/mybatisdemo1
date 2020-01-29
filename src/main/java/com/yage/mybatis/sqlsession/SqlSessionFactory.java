package com.yage.mybatis.sqlsession;

/**
 * @Author LOL_toulan
 * @Time 2020/1/28 18:31
 * @Message
 */
public interface SqlSessionFactory {


    /**
     * 用于打开一个新的sqlSession对象
     * @return
     */
    SqlSession openSession();
}
