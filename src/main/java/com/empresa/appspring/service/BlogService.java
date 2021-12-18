package com.empresa.appspring.service;

import java.util.List;

import com.empresa.appspring.model.Post;
import com.empresa.appspring.repository.BlogRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlogService implements BlogServiceInterface{

    private BlogRepository blogRepository; 
    
    @Override
    public List<Post> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return this.blogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return this.blogRepository.save(post);
    }
    
}
