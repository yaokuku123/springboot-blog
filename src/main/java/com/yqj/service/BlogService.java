package com.yqj.service;

import com.yqj.domain.Blog;
import com.yqj.domain.BlogQuery;
import com.yqj.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: BlogService
 * Author: yaoqijun
 * Date: 2020/8/6 14:43
 */
public interface BlogService {

    Blog getBlog(Long id);

    //分页条件查询
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
