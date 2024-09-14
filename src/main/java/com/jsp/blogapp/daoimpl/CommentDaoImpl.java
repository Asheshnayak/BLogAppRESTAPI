package com.jsp.blogapp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.blogapp.Exception.EntityNotFoundException;
import com.jsp.blogapp.dao.CommentDAO;
import com.jsp.blogapp.dao.PostDAO;
import com.jsp.blogapp.dao.UserDAO;
import com.jsp.blogapp.entity.CommentEntity;
import com.jsp.blogapp.entity.PostEntity;
import com.jsp.blogapp.entity.UserEntity;
import com.jsp.blogapp.repository.CommentRepository;
@Repository
public class CommentDaoImpl implements CommentDAO {
	@Autowired
	private CommentRepository repository;
	
	
	@Autowired
	private PostDAO postDao;
	
	
	@Autowired
	private UserDAO userDao;
	
	

	@Override
	public CommentEntity saveComment(CommentEntity comment, int userId, int postId) {
		UserEntity userEntity=userDao.fetchUser(userId);
		PostEntity postEntity=postDao.fetchPost(postId);
		
		comment.setPostEntity(postEntity);
		comment.setUserEntity(userEntity);
		
		return repository.save(comment);
	}

	@Override
	public CommentEntity updateComment(CommentEntity comment, int id) {
		if(!repository.existsById(id)) {
			throw new EntityNotFoundException("comment with the id:"+id+"is not present");
		}
		comment.setCommentId(id);
		return repository.save(comment);
	}

	@Override
	public CommentEntity fetchComment(int id) {
		Optional <CommentEntity> optional=repository.findById(id);
		if(optional.isEmpty()) {
			throw new EntityNotFoundException("comment with the id:"+id+"is not present");
		}
		return optional.get();
	}

	@Override
	public List<CommentEntity> fetchAllCommentForPost(int postId) {
		PostEntity postEntity =postDao.fetchPost(postId);
		List <CommentEntity> list=postEntity.getComment();
		if(list.isEmpty()) {
			throw new EntityNotFoundException("comment for the post with the "+postId+"is not present");
		}
		return list;
	}

	@Override
	public CommentEntity deleteComment(int id) {
		CommentEntity commentEntity= fetchComment(id);
		repository.delete(commentEntity);
		return commentEntity;
	}

	@Override
	public boolean deleteCommentForAPost(int id) {
		PostEntity postEntity=postDao.fetchPost(id);
		postEntity.setComment(null);
		postDao.updatePost(postEntity, id);
		return true;
	}

}
