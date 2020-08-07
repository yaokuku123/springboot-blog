package com.yqj.service;

import com.yqj.dao.TagDao;
import com.yqj.domain.Tag;
import com.yqj.handler.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public Page<Tag> listTag(Pageable pageable) {
        return tagDao.findAll(pageable);
    }

    @Transactional
    @Override
    public List<Tag> listTag() {
        return tagDao.findAll();
    }

    @Transactional
    @Override
    public List<Tag> listTag(String ids) {
        List<Long> idsList = convertToList(ids);
        return tagDao.findAllById(idsList);
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return tagDao.findTop(pageable);
    }

    //将字符串ids转换为list形式
    private List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids != null){
            String[] idArray = ids.split(",");
            for (int i = 0; i < idArray.length; i++) {
                list.add(new Long(idArray[i]));
            }
        }
        return list;
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
