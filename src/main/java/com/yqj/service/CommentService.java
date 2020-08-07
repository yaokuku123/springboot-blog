package com.yqj.service;

import com.yqj.domain.Comment;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: CommentService
 * Author: yaoqijun
 * Date: 2020/8/7 17:14
 */
public interface CommentService {

    //查询当前博客的评论数据
    List<Comment> listCommentByBlogId(Long blogId);

    //保存评论
    Comment saveComment(Comment comment);
}
