package com.yqj.controller;

import com.yqj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: ArchiveController
 * Author: yaoqijun
 * Date: 2020/8/8 15:25
 */
@Controller
public class ArchiveController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "archives";
    }
}
