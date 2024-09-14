package com.jsp.blogapp.service;

import java.util.List;

import com.jsp.blogapp.dto.ResponseStructureDTO;
import com.jsp.blogapp.entity.CommentEntity;

public interface CommentService {
	ResponseStructureDTO <CommentEntity> saveComment(CommentEntity com,int userId,int postId);
	ResponseStructureDTO<CommentEntity> updateComment(CommentEntity com,int id);
	ResponseStructureDTO<CommentEntity> fetchComment(int id);
	ResponseStructureDTO<List<CommentEntity>> fetchCommentForPost(int postId);
	ResponseStructureDTO<CommentEntity> deleteComment(int id);
	ResponseStructureDTO<String> deleteCommentForPost(int postId);
	
	
	


}
