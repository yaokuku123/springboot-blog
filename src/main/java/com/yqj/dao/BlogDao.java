package com.yqj.dao;

import com.yqj.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: BlogDao
 * Author: yaoqijun
 * Date: 2020/8/6 14:45
 */
public interface BlogDao extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    //查询推荐的前几个数据
    @Query("select b from Blog b where b.recommend=true ")
    List<Blog> findTop(Pageable pageable);

    //分页模糊查询
    @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query,Pageable pageable);

    //更新访问量
    @Modifying
    @Query("update Blog b set b.views=b.views+1 where b.id=?1")
    int updateViews(Long id);
}
