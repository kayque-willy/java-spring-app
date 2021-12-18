package com.empresa.appspring.service;

import java.util.List;

import com.empresa.appspring.model.Post;

public interface BlogServiceInterface {
    List <Post> findAll();
    Post findById(Long id);
    Post save(Post post);
}
