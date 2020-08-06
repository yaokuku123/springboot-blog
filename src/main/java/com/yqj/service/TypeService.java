package com.yqj.service;

import com.yqj.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: TypeService
 * Author: yaoqijun
 * Date: 2020/8/6 9:33
 */
public interface TypeService {
    //增
    Type saveType(Type type);

    //查
    Type getType(Long id);

    //根据名字查
    Type getTypeByName(String name);

    //分页查询
    Page<Type> listType(Pageable pageable);

    //改
    Type updateType(Long id ,Type type);

    //删
    void deleteType(Long id);
}
