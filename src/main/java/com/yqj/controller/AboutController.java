package com.yqj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: AboutController
 * Author: yaoqijun
 * Date: 2020/8/8 16:11
 */
@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
