package com.yqj.service;

import com.yqj.dao.TagDao;
import com.yqj.domain.Tag;
import com.yqj.handler.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: TagServiceImpl
 * Author: yaoqijun
 * Date: 2020/8/6 13:35
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Transactional
    @Override
    public Tag saveType(Tag tag) {
        return tagDao.save(tag);
    }

    @Transactional
    @Override
    public Tag getType(Long id) {
        return tagDao.findById(id).get();
    }

    @Transactional
    @Override
    public Tag getTypeByName(String name) {
        return tagDao.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listType(Pageable pageable) {
        return tagDao.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateType(Long id, Tag tag) {
        Tag t = tagDao.findById(id).get();
        if (t == null){
            throw new NotFoundException("不存在");
        }
        BeanUtils.copyProperties(tag,t);
        return tagDao.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        tagDao.deleteById(id);
    }
}
