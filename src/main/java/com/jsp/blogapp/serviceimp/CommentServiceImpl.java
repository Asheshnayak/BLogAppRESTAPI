package com.jsp.blogapp.serviceimp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.blogapp.dao.CommentDAO;
import com.jsp.blogapp.dto.ResponseStructureDTO;
import com.jsp.blogapp.entity.CommentEntity;
import com.jsp.blogapp.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	
	
	@Autowired
	private CommentDAO commentDao;

	@Override
	public ResponseStructureDTO<CommentEntity> saveComment(CommentEntity com, int userId, int postId) {
		com.setCreationTime(LocalDateTime.now());
		CommentEntity saveComment = commentDao.saveComment(com, userId, postId);
		
		return new ResponseStructureDTO<CommentEntity> (HttpStatus.OK.value(),"comment saved sussfully",saveComment,LocalDateTime.now());
	
	}

	@Override
	public ResponseStructureDTO<CommentEntity> updateComment(CommentEntity com, int id) {
		CommentEntity updateComment = commentDao.updateComment(com, id);
		return new ResponseStructureDTO<CommentEntity> (HttpStatus.OK.value(),"comment updated successfully",updateComment,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<CommentEntity> fetchComment(int id) {
		CommentEntity fetchComment = commentDao.fetchComment(id);
		return new ResponseStructureDTO<CommentEntity> (HttpStatus.OK.value(),"comment retrevet succfully",fetchComment,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<List<CommentEntity>> fetchCommentForPost(int postId) {
		List<CommentEntity> fetchAllCommentForPost = commentDao.fetchAllCommentForPost(postId);
		fetchAllCommentForPost.sort((c1,c2)->c1.getCreationTime().compareTo(c2.getCreationTime()));
		return new ResponseStructureDTO<> (HttpStatus.OK.value(),"All comment retreved successfully",fetchAllCommentForPost,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<CommentEntity> deleteComment(int id) {
		CommentEntity deleteComment = commentDao.deleteComment(id);
		return new ResponseStructureDTO<CommentEntity> (HttpStatus.OK.value(),"comment deleted successfully",deleteComment,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<String> deleteCommentForPost(int postId) {
		commentDao.deleteCommentForAPost(postId);
		return new ResponseStructureDTO<>(HttpStatus.OK.value(),"comment deleted sucessfully","comment for the post"+postId+"deleted successfully",LocalDateTime.now());
		
	}

}
