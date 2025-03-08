package com.apis.services;

import java.util.List;

import com.apis.entites.Post;
import com.apis.payloads.PostDto;
import com.apis.payloads.PostResponce;

public interface PostService {
	//create
	PostDto createPost(PostDto postDto , Integer userId , Integer categaryId);
	
	
	//update
	PostDto updatePost(PostDto postDto , Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all post
	PostResponce getAllPost( Integer pageNumber , Integer pageSize, String sortBy , String sortDir);
	
	// get single 
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getAllPostsByCategory(Integer categoryId);

	// get All post by user 
	List<PostDto> getAllPostsByUser(Integer userId);
	
	//search
	List<PostDto> searchPosts(String keyword);
}
