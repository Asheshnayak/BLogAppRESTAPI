package com.jsp.blogapp.dao;

import java.util.List;

import com.jsp.blogapp.entity.UserEntity;

public interface UserDAO {
	UserEntity saveUser(UserEntity user);
	UserEntity updateUser(UserEntity user,int id);
	UserEntity fetchUser(int id);
	List<UserEntity> fetchAllUser();
	UserEntity deleteUser(int id);
}
