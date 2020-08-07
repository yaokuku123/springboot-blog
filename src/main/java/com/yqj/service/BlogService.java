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

    //获取转换为HTML的博客
    Blog getAndConvert(Long id);

    //分页条件查询
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    //分页查询
    Page<Blog> listBlog(Pageable pageable);

    //分页模糊查询
    Page<Blog> listBlog(Pageable pageable,String query);

    //按更新时间查询前几条数据
    List<Blog> listRecommendBlogTop(Integer size);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
