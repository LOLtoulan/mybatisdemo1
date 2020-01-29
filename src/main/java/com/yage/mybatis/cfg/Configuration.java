package com.yage.mybatis.cfg;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LOL_toulan
 * @Time 2020/1/28 18:51
 * @Message 自定义mybatis的配置类
 */

public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String, Mapper> mappers = new HashMap<String,Mapper>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers); //防止下一次赋值将上一次赋的值给覆盖掉，所以我们这里使用的是追加模式。
    }
}
