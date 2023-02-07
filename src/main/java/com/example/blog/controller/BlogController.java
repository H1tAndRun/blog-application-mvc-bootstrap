package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public String blogMain(Model model) {
        model.addAttribute("posts", blogService.findAllPost());
        return "blog-main";
    }

    @GetMapping("/add")
    public String addPost(Model model) {
        model.addAttribute(new Post());
        return "blog-add";
    }

    @PostMapping("/add")
    public String blogPostAdd(Post post) {
        blogService.createPost(post);
        return "redirect:/blog";
    }

    @GetMapping("/{id}")
    public String blogDetails (@PathVariable Integer id,Model model) {
        model.addAttribute("post",blogService.findById(id));
        return "blog-details";
    }

    @PostMapping("/delete/{id}")
    public String blogPostDelete(@PathVariable Integer id){
        blogService.deletePost(id);
        return "redirect:/blog";
    }
    @GetMapping("/edit/{id}")
    public String postPostEdit(@PathVariable Integer id,Model model){
        model.addAttribute("post",blogService.findById(id));
        return "blog-edit";
    }
    @PostMapping("/edit/{id}")
    public String blogPostEdit(Post post) {
        blogService.createPost(post);
        return "redirect:/blog";
    }
}
