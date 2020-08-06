package com.yqj.service;

import com.yqj.domain.Tag;
import com.yqj.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: TagService
 * Author: yaoqijun
 * Date: 2020/8/6 13:34
 */
public interface TagService {
    //增
    Tag saveType(Tag tag);

    //查
    Tag getType(Long id);

    //根据名字查
    Tag getTypeByName(String name);

    //分页查询
    Page<Tag> listType(Pageable pageable);

    //改
    Tag updateType(Long id ,Tag tag);

    //删
    void deleteType(Long id);
}
