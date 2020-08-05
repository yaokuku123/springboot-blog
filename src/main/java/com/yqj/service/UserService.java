package com.yqj.service;

import com.yqj.domain.User;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: UserService
 * Author: yaoqijun
 * Date: 2020/8/5 11:35
 */
public interface UserService {

    User checkUser(String username,String password);
}
