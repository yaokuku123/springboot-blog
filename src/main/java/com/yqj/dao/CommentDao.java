package com.yqj.dao;

import com.yqj.domain.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: CommentDao
 * Author: yaoqijun
 * Date: 2020/8/7 17:17
 */
public interface CommentDao extends JpaRepository<Comment,Long> {

    //根据博客id查询数据
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
