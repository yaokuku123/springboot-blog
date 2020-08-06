package com.yqj.dao;

import com.yqj.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: TypeDao
 * Author: yaoqijun
 * Date: 2020/8/6 9:35
 */
public interface TypeDao extends JpaRepository<Type,Long> {
    Type findByName(String name);
}
