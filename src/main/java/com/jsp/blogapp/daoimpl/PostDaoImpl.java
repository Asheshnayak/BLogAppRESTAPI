package com.jsp.blogapp.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.blogapp.Exception.EntityNotFoundException;
import com.jsp.blogapp.dao.PostDAO;
import com.jsp.blogapp.dao.UserDAO;
import com.jsp.blogapp.entity.PostEntity;
import com.jsp.blogapp.entity.UserEntity;
import com.jsp.blogapp.repository.PostRepository;
@Repository
public class PostDaoImpl implements PostDAO {
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private UserDAO userdao;
	
	

	@Override
	public PostEntity savePost(PostEntity postEntity, int userId) {
		UserEntity userEntity=userdao.fetchUser(userId);
		postEntity.setUserEntity(userEntity);
		return repository.save(postEntity);
	}

	@Override
	public PostEntity updatePost(PostEntity post, int id) {
		boolean existsById=repository.existsById(id);
		if(!existsById) {
			throw new EntityNotFoundException("post with id"+id+"is not found");
		}
		return repository.save(post);
	}

	@Override
	public PostEntity fetchPost(int id) {
		Optional <PostEntity> optional=repository.findById(id);
		if(optional.isEmpty()) {
			throw new EntityNotFoundException("post with the id"+id+"is not present");
			
		}
		return optional.get();
	}

	@Override
	public List<PostEntity> fetchAllPost() {
		List<PostEntity> list=repository.findAll();
		if(list.isEmpty()) {
			throw new EntityNotFoundException("no post data avaible in data base");
		}
		return list;
	}

	@Override
	public List<PostEntity> fetchPostsByUserId(int id) {
		UserEntity userEntity=userdao.fetchUser(id);
		return userEntity.getPost();
	}

	@Override
	public PostEntity deletePost(int id) {
			PostEntity postEntity = fetchPost(id);
			repository.delete(postEntity);
			return postEntity;
	}

}
