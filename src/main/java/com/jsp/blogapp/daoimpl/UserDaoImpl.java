package com.jsp.blogapp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.blogapp.Exception.EntityAlreadyExistsException;
import com.jsp.blogapp.Exception.EntityNotFoundException;
import com.jsp.blogapp.dao.UserDAO;
import com.jsp.blogapp.entity.UserEntity;
import com.jsp.blogapp.repository.UserRepository;
@Repository
public class UserDaoImpl implements UserDAO{
	@Autowired
	private UserRepository repository;

	@Override
	public UserEntity saveUser(UserEntity user) {
		boolean existByEmail=repository.existsByEmail(user.getEmail());
		boolean existByPhone=repository.existsByPhoneNo(user.getPhoneNo());
		if(existByEmail) {
			throw new EntityAlreadyExistsException("User already exists with email:"+user.getEmail());
		}
		if(existByPhone) {
			throw new EntityAlreadyExistsException("user already exists with phoneNo:"+user.getPhoneNo());
		}
		return repository.save(user);
	}

	@Override
	public UserEntity updateUser(UserEntity user, int id) {
		user.setUserId(id);
		boolean existsById=repository.existsById(id);
		if(!existsById) {
			throw new EntityNotFoundException("usr not found with the id:"+id);
		}
		
		return saveUser(user);
	}

	@Override
	public UserEntity fetchUser(int id) {
		Optional <UserEntity> optional=repository.findById(id);
		if(optional.isEmpty()) {
			throw new EntityNotFoundException("user not found with the id:"+id);
		}
		return optional.get();
	}

	@Override
	public List<UserEntity> fetchAllUser() {
		List<UserEntity> list=repository.findAll();
		if(list.isEmpty()) {
			throw new EntityNotFoundException("user data not available i data basse");
		}
		return list;
	}

	@Override
	public UserEntity deleteUser(int id) {
		UserEntity user=fetchUser(id);
		repository.delete(user);
		return user;
	}
	
}
