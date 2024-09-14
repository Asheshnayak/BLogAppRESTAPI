package com.jsp.blogapp.service;

import java.util.List;

import com.jsp.blogapp.dto.ResponseStructureDTO;
import com.jsp.blogapp.entity.PostEntity;

public interface PostService {
	ResponseStructureDTO <PostEntity> savePost(PostEntity post,int userId);
	ResponseStructureDTO<PostEntity> updatePost(PostEntity post,int id);
	ResponseStructureDTO<PostEntity> fetchPost(int id);
	ResponseStructureDTO<List<PostEntity>> fetchAllPost();
	ResponseStructureDTO<List<PostEntity>> fetchPostsByUserId(int id);
	ResponseStructureDTO<PostEntity> deletePost(int id);
}
