package com.yqj.service;

import com.yqj.domain.Blog;
import com.yqj.domain.BlogQuery;
import com.yqj.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

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

    //根据标签id查询
    Page<Blog> listBlog(Pageable pageable,Long tagId);

    //按更新时间查询前几条数据
    List<Blog> listRecommendBlogTop(Integer size);

    //按年份查找每个年份的博客数据集合
    Map<String,List<Blog>> archiveBlog();

    //博客数目
    Long countBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
