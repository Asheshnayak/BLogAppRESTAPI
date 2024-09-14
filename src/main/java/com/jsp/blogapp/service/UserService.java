package com.jsp.blogapp.service;

import java.util.List;

import com.jsp.blogapp.dto.ResponseStructureDTO;
import com.jsp.blogapp.entity.UserEntity;

public interface UserService {
	ResponseStructureDTO<UserEntity> saveUser(UserEntity user);
	ResponseStructureDTO <UserEntity> updateUser(UserEntity user,int id);
	ResponseStructureDTO <UserEntity> fetchUser(int id);
	ResponseStructureDTO<List<UserEntity>> fetchAllUsers();
	ResponseStructureDTO<UserEntity> deleteUser(int id);
}
