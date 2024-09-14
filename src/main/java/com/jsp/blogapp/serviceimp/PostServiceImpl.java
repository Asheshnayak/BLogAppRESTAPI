package com.jsp.blogapp.serviceimp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.blogapp.dao.PostDAO;
import com.jsp.blogapp.dto.ResponseStructureDTO;
import com.jsp.blogapp.entity.PostEntity;
import com.jsp.blogapp.service.PostService;
@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDAO postDao;

	@Override
	public ResponseStructureDTO<PostEntity> savePost(PostEntity post, int userId) {
		post.setCreationTime(LocalDateTime.now());
		PostEntity savePost = postDao.savePost(post, userId);
		
		return new ResponseStructureDTO <PostEntity>(HttpStatus.OK.value(),"Post saved successfully",savePost,LocalDateTime.now());
		
	}

	@Override
	public ResponseStructureDTO<PostEntity> updatePost(PostEntity post, int id) {
		PostEntity updatePost = postDao.updatePost(post, id);
		return new ResponseStructureDTO <PostEntity> (HttpStatus.OK.value(),"Post updated successfully",updatePost,LocalDateTime.now()); 
		
	}

	@Override
	public ResponseStructureDTO<PostEntity> fetchPost(int id) {
		PostEntity fetchPost = postDao.fetchPost(id);
		return new ResponseStructureDTO <PostEntity> (HttpStatus.OK.value(),"Post retreved successfully",fetchPost,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<List<PostEntity>> fetchAllPost() {
		List<PostEntity> fetchAllPost = postDao.fetchAllPost();
		fetchAllPost.sort((p1,p2)->p1.getCreationTime().compareTo(p2.getCreationTime()));
		return new ResponseStructureDTO <List<PostEntity>> (HttpStatus.OK.value(),"Post retreved successfully",fetchAllPost,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<List<PostEntity>> fetchPostsByUserId(int id) {
		List<PostEntity> fetchPostsByUserId = postDao.fetchPostsByUserId(id);
		fetchPostsByUserId.sort((p1,p2)->p1.getCreationTime().compareTo(p2.getCreationTime()));
		return new ResponseStructureDTO<List<PostEntity>> (HttpStatus.OK.value(),"Post retreved successfully",fetchPostsByUserId,LocalDateTime.now());
	}

	@Override
	public ResponseStructureDTO<PostEntity> deletePost(int id) {
		PostEntity deletePost = postDao.deletePost(id);
		return new ResponseStructureDTO <PostEntity> (HttpStatus.OK.value(),"Post deleted successfully",deletePost,LocalDateTime.now());
	}
	
	
}
