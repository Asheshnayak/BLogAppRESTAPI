package com.jsp.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.blogapp.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	public boolean existsByEmail(String email);
	public boolean existsByPhoneNo(Long phoneNo);
}
