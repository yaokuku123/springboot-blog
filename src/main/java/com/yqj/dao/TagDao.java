package com.yqj.dao;

import com.yqj.domain.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: TagDao
 * Author: yaoqijun
 * Date: 2020/8/6 13:36
 */
public interface TagDao extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
