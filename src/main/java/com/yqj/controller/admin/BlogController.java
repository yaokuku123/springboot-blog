package com.yqj.controller.admin;

import com.yqj.domain.Blog;
import com.yqj.domain.BlogQuery;
import com.yqj.domain.User;
import com.yqj.service.BlogService;
import com.yqj.service.TagService;
import com.yqj.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size =10,sort = "updateTime",direction = Sort.Direction.DESC)
                        Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size =10,sort = "updateTime",direction = Sort.Direction.DESC)
                                Pageable pageable, BlogQuery blog,Model model){
        model.addAttribute("page",blogService.listBlog(pageable,blog));
        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        return "admin/blogs-input";
    }

    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        Blog blog = blogService.getBlog(id);
        blog.init();
        model.addAttribute("blog",blog);
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        Blog b;
        if (blog.getId() == null){
            b = blogService.saveBlog(blog);
        }else {
            b = blogService.updateBlog(blog.getId(),blog);
        }

        if (b == null){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }
}
