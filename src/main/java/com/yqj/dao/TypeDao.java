package com.yqj.dao;

import com.yqj.domain.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: TypeDao
 * Author: yaoqijun
 * Date: 2020/8/6 9:35
 */
public interface TypeDao extends JpaRepository<Type,Long> {
    Type findByName(String name);

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
