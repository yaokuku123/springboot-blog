package com.yqj.test;

import com.yqj.dao.UserDao;
import com.yqj.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: JpaTest
 * Author: yaoqijun
 * Date: 2020/8/5 12:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        User user = new User();
        user.setUsername("yorick");
        user.setPassword("e348fb9877c58259d1c7b89d3833db32");
        userDao.save(user);
    }
}
