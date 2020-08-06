package com.yqj.controller.admin;

import com.yqj.domain.Blog;
import com.yqj.domain.BlogQuery;
import com.yqj.service.BlogService;
import com.yqj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: BlogController
 * Author: yaoqijun
 * Date: 2020/8/5 13:30
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size =2,sort = "updateTime",direction = Sort.Direction.DESC)
                        Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size =2,sort = "updateTime",direction = Sort.Direction.DESC)
                                Pageable pageable, BlogQuery blog,Model model){
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogs :: blogList";
    }
}
