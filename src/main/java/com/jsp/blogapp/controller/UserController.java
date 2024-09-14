package com.jsp.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.blogapp.dto.ResponseStructureDTO;
import com.jsp.blogapp.entity.UserEntity;
import com.jsp.blogapp.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity <ResponseStructureDTO<UserEntity>> saveUser(@RequestBody UserEntity user){
		ResponseStructureDTO<UserEntity> saveUser = userService.saveUser(user);
		return new ResponseEntity<>(saveUser,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity <ResponseStructureDTO<UserEntity>> updateUser(@RequestBody UserEntity user,@PathVariable("id")int id){
		ResponseStructureDTO<UserEntity> updateUser = userService.updateUser(user, id);
		return new ResponseEntity<ResponseStructureDTO<UserEntity>>(updateUser,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseStructureDTO<UserEntity>> fetchUser(@PathVariable("id") int id){
		ResponseStructureDTO<UserEntity> fetchUser = userService.fetchUser(id);
		return new ResponseEntity<ResponseStructureDTO<UserEntity>>(fetchUser,HttpStatus.OK);
	}
	@GetMapping("get")
	public ResponseEntity <ResponseStructureDTO<List<UserEntity>>> fetchAllUser(){ 
		ResponseStructureDTO<List<UserEntity>> fetchAllUsers = userService.fetchAllUsers();
		return new ResponseEntity<ResponseStructureDTO<List<UserEntity>>>(fetchAllUsers,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructureDTO<UserEntity>> deleteUser(@PathVariable("id") int id){
			ResponseStructureDTO<UserEntity> deleteUser = userService.deleteUser(id);
			return new ResponseEntity<ResponseStructureDTO<UserEntity>>(deleteUser,HttpStatus.OK);
	}
	
}
