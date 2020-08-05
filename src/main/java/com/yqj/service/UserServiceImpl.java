package com.yqj.service;

import com.yqj.dao.UserDao;
import com.yqj.domain.User;
import com.yqj.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: UserServiceImpl
 * Author: yaoqijun
 * Date: 2020/8/5 11:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
