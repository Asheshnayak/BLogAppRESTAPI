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
import com.jsp.blogapp.entity.PostEntity;
import com.jsp.blogapp.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	public PostService postService;
	
	@PostMapping("/save/{id}")
	public ResponseEntity <ResponseStructureDTO<PostEntity>> savePost(@RequestBody PostEntity postEntity, @PathVariable("id") int userId){
		ResponseStructureDTO<PostEntity> savePost = postService.savePost(postEntity, userId);
		return new ResponseEntity<>(savePost,HttpStatus.OK);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseStructureDTO<PostEntity>> updatePost(@RequestBody PostEntity postEntity,@PathVariable("id") int id){
		ResponseStructureDTO<PostEntity> updatePost = postService.updatePost(postEntity, id);
		return new ResponseEntity<>(updatePost,HttpStatus.OK);
	}
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructureDTO<PostEntity>> fetchPost(@PathVariable("id") int id){
		ResponseStructureDTO<PostEntity> fetchPost = postService.fetchPost(id);
		return new ResponseEntity<>(fetchPost,HttpStatus.OK);
	}
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructureDTO<List<PostEntity>>> fetchAllPost(){
		ResponseStructureDTO<List<PostEntity>> fetchAllPost = postService.fetchAllPost();
		return new ResponseEntity<>(fetchAllPost,HttpStatus.OK);
	}
	@GetMapping("/fetchByUser/{id}")
	public ResponseEntity<ResponseStructureDTO<List<PostEntity>>> fetchPostByUserId(@PathVariable("id")int id){
		ResponseStructureDTO<List<PostEntity>> fetchPostsByUserId = postService.fetchPostsByUserId(id);
		return new ResponseEntity<ResponseStructureDTO<List<PostEntity>>> (fetchPostsByUserId,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructureDTO<PostEntity>> deletePost(@PathVariable("id") int id){
		ResponseStructureDTO<PostEntity> deletePost = postService.deletePost(id);
		return new ResponseEntity<ResponseStructureDTO<PostEntity>>(deletePost,HttpStatus.OK);
	}
	
}
