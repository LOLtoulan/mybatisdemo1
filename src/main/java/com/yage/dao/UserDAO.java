package com.yage.dao;

import com.yage.domain.User;
import com.yage.mybatis.annotations.Select;

import java.util.List;

/**
 * @Author LOL_toulan
 * @Time 2020/1/27 17:54
 * @Message
 */
public interface UserDAO {
    List<User> findAll();
}
