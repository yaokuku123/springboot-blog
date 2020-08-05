package com.yqj.dao;

import com.yqj.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: UserDao
 * Author: yaoqijun
 * Date: 2020/8/5 11:36
 */
public interface UserDao extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);
}
