package com.yqj.dao;

import com.yqj.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: BlogDao
 * Author: yaoqijun
 * Date: 2020/8/6 14:45
 */
public interface BlogDao extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {
}
