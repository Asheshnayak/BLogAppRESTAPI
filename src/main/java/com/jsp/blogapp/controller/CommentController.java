package com.jsp.blogapp.controller;

import java.util.List;

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
import com.jsp.blogapp.entity.CommentEntity;
import com.jsp.blogapp.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	private CommentService commentService;
	
	
	@PostMapping("/save/{userId}/{postId}")
	public ResponseEntity <ResponseStructureDTO<CommentEntity>> saveComment(@RequestBody CommentEntity 
			commentEntity,@PathVariable("userId") int userId,@PathVariable("postId") int postId){
		ResponseStructureDTO<CommentEntity> saveComment = commentService.saveComment(commentEntity, userId, postId);
		return new ResponseEntity<>(saveComment,HttpStatus.OK);
	}
	@PutMapping("update/{id}")
	public ResponseEntity <ResponseStructureDTO<CommentEntity>> updateComment(@RequestBody CommentEntity comment,
			@PathVariable("id") int id){
		ResponseStructureDTO<CommentEntity> updateComment = commentService.updateComment(comment, id);
		return new ResponseEntity<>(updateComment,HttpStatus.OK);
	}
	@GetMapping("/fetchforPost/{postId}")
	public ResponseEntity <ResponseStructureDTO<List<CommentEntity>>> fetchCommentsForPost(@PathVariable("postId") int postId){
		ResponseStructureDTO<List<CommentEntity>> fetchCommentForPost = commentService.fetchCommentForPost(postId);
		return new ResponseEntity<>(fetchCommentForPost,HttpStatus.OK);
	}
	@GetMapping("/fetch/{id}")
	public ResponseEntity <ResponseStructureDTO<CommentEntity>> fetchComment(@PathVariable("id") int id){
		ResponseStructureDTO<CommentEntity> fetchComment = commentService.fetchComment(id);
		return new ResponseEntity<>(fetchComment,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructureDTO<CommentEntity>> deleteComment(@PathVariable("id") int id){
		ResponseStructureDTO<CommentEntity> deleteComment = commentService.deleteComment(id);
		return new ResponseEntity<>(deleteComment,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructureDTO<String>> deleteCommentForPost(@PathVariable("postId") int postId){
		ResponseStructureDTO<String> deleteCommentForPost = commentService.deleteCommentForPost(postId);
		return new ResponseEntity<>(deleteCommentForPost,HttpStatus.OK);
	}
	
}
