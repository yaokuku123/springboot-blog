package com.yqj.controller;

import com.yqj.handler.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Copyright(C),2019-2020,XXX公司
 * FileName: IndexController
 * Author: yaoqijun
 * Date: 2020/8/4 16:29
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){

        return "admin/input";
    }



}
