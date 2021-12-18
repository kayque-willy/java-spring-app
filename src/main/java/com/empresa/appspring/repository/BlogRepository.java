package com.empresa.appspring.repository;

import com.empresa.appspring.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Post, Long>{
    
}
