package com.yqj.dao;

import com.yqj.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: TagDao
 * Author: yaoqijun
 * Date: 2020/8/6 13:36
 */
public interface TagDao extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
