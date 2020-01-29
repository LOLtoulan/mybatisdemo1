package com.yage.mybatis.cfg;

import lombok.Data;

/**
 * @Author LOL_toulan
 * @Time 2020/1/28 18:55
 * @Message
 */

public class Mapper {
    private String queryString;  //sql语句
    private String resultType;  //实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
