package com.jsp.blogapp.serviceimp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.blogapp.dao.UserDAO;
import com.jsp.blogapp.dto.ResponseStructureDTO;
import com.jsp.blogapp.entity.UserEntity;
import com.jsp.blogapp.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDao;

	@Override
	public ResponseStructureDTO<UserEntity> saveUser(UserEntity user) {
		UserEntity userEntity=userDao.saveUser(user);
		return new ResponseStructureDTO<>(HttpStatus.OK.value(),"user saved successfully",userEntity,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<UserEntity> updateUser(UserEntity user, int id) {
		UserEntity userEntity=userDao.updateUser(user, id);
		return new ResponseStructureDTO<>(HttpStatus.OK.value(),"user updated successfully",userEntity,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<UserEntity> fetchUser(int id) {
		
		UserEntity userEntity=userDao.fetchUser(id);
		return new ResponseStructureDTO<>(HttpStatus.OK.value(),"user data fetched successfully",userEntity,LocalDateTime.now());
		
	}

	@Override
	public ResponseStructureDTO<List<UserEntity>> fetchAllUsers() {
		List<UserEntity> fetchAllUser = userDao.fetchAllUser();
		return new ResponseStructureDTO<>(HttpStatus.OK.value(),"user saved successfully",fetchAllUser,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<UserEntity> deleteUser(int id) {
		UserEntity deleteUser = userDao.deleteUser(id);
		return new ResponseStructureDTO<>(HttpStatus.OK.value(),"user deleted successfully",deleteUser,LocalDateTime.now());
	}

}
