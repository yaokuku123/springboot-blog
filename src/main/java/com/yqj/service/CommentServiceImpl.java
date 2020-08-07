package com.yqj.service;

import com.yqj.dao.CommentDao;
import com.yqj.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: CommentServiceImpl
 * Author: yaoqijun
 * Date: 2020/8/7 17:16
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Transactional
    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
        return commentDao.findByBlogId(blogId,sort);
    }

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if(parentCommentId!=-1){
            comment.setParentComment(commentDao.findById(parentCommentId).get());
        }else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentDao.save(comment);
    }
}
