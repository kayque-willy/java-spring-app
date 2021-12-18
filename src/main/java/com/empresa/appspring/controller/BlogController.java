package com.empresa.appspring.controller;

import java.util.List;

import com.empresa.appspring.model.Post;
import com.empresa.appspring.service.BlogService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BlogController {

    private BlogService blogService;
    public List<Post> posts; 

    @GetMapping("/posts")
    public ModelAndView getPosts() {
        // Busca os posts
        this.posts = blogService.findAll();
        // Cria a view e adiciona os posts
        ModelAndView mv = new ModelAndView();
        mv.addObject("posts", posts);
        return mv;
    }

}
