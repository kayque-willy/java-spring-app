package com.empresa.appspring.controller;

import java.util.List;

import com.empresa.appspring.model.Post;
import com.empresa.appspring.service.BlogService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BlogController {

    private BlogService blogService;
    public List<Post> posts;

    // Para que o @RequestMapping seja acessado pela view, é utilizado o nome padrão
    // com base nas letras maiúsculas da classe e no nome completo do método.
    // Por exemplo, o método getPosts() recebe o nome "BG#getPosts" e é acessdo na
    // view como mvc.url("BG#getPosts")

    // ----------------- Listagem de posts -----------------
    @GetMapping("/posts")
    public ModelAndView getPosts() {
        // Busca os posts
        this.posts = blogService.findAll();
        // Cria a view e adiciona os posts
        ModelAndView mv = new ModelAndView("post/posts");
        mv.addObject("posts", posts);
        return mv;
    }

    // ----------------- Detalhes do post -----------------
    @GetMapping("/posts/{id}")
    public ModelAndView getPost(@PathVariable("id") long id) {
        // Busca o post pelo id
        Post post = blogService.findById(id);
        // Cria a view e adiciona o post
        ModelAndView mv = new ModelAndView("post/post-details");
        mv.addObject("post", post);
        return mv;
    }

}
