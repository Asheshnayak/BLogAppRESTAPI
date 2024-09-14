package com.jsp.blogapp.dao;

import java.util.List;

import com.jsp.blogapp.entity.PostEntity;

public interface PostDAO {
	PostEntity savePost(PostEntity post,int userId);
	PostEntity updatePost(PostEntity post,int id);
	PostEntity fetchPost(int id);
	List <PostEntity> fetchAllPost();
	List<PostEntity> fetchPostsByUserId(int id);
	PostEntity deletePost(int id);
}
