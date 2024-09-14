package com.jsp.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.blogapp.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

}
