package com.jsp.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.blogapp.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity,Integer> {

}
