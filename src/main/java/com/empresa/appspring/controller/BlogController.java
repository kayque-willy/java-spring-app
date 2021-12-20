package com.empresa.appspring.controller;

import java.time.LocalDate;
import java.util.List;

import com.empresa.appspring.model.Post;
import com.empresa.appspring.service.BlogService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BlogController {

    private BlogService blogService;
    public List<Post> posts;

    // ----------------- Index -----------------
    @RequestMapping("/")
    public String index() {
        return "redirect:/posts";
    }

    // ----------------- Listagem de posts -----------------
    @GetMapping("/posts")
    public ModelAndView getPosts() {
        // Busca os posts
        this.posts = blogService.findAll();
        // Cria a view e adiciona os posts
        ModelAndView mv = new ModelAndView("post/post-list");
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

    // ----------------- Criação do post -----------------
    // Carrega a pagina de novo post
    @GetMapping("/newpost")
    public ModelAndView getPostForm() {
        // Gera novo post
        Post post = new Post();
        // Cria a view e adiciona o post
        ModelAndView mv = new ModelAndView("post/new-post");
        mv.addObject("post", post);
        return mv;
    }

    // Recebe o POST enviado pelo formulário
    // O @Validated verifica se o objeto cumpriu as validações da anotação da jpa
    @PostMapping("/newpost")
    public String savePost(@Validated Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            // Redireciona para novo post
            return "redirect:/newpost";
        }
        // Salva o post no banco de dados
        post.setData(LocalDate.now());
        blogService.save(post);
        // Redireciona para a listagem de posts
        return "redirect:/posts";
    }

    // ----------------- Remoção do post -----------------
    @PostMapping("/remove")
    public String deletePost(@Validated Post post, BindingResult result, RedirectAttributes attributes) {
        blogService.remove(post);
        // Redireciona para a listagem de posts
        return "redirect:/posts";
    }

    // ----------------- Editar post -----------------
    // Carrega a pagina de edição do post
    // @GetMapping("/editpost")
    // public ModelAndView getPostFormEdit() {
    // // Busca o post pelo id
    // Post post = blogService.findById(1l);
    // // Cria a view e adiciona o post
    // ModelAndView mv = new ModelAndView("post/new-post");
    // mv.addObject("post", post);
    // return mv;
    // }

}
