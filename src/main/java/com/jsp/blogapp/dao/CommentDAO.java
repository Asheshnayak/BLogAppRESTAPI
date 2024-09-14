package com.jsp.blogapp.dao;

import java.util.List;

import com.jsp.blogapp.entity.CommentEntity;

public interface CommentDAO {
	CommentEntity saveComment(CommentEntity comment,int userId,int postId);
	CommentEntity updateComment (CommentEntity comment,int id);
	CommentEntity fetchComment(int id);
	List<CommentEntity> fetchAllCommentForPost(int postId);
	CommentEntity deleteComment(int id);
	boolean deleteCommentForAPost(int id);
}
