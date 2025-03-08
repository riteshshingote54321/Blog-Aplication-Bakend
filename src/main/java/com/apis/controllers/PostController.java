package com.apis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apis.entites.Post;
import com.apis.payloads.ApiResponce;
import com.apis.payloads.PostDto;
import com.apis.payloads.PostResponce;
import com.apis.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	 
	//create
	@PostMapping("user/{userId}/categary/{categaryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto ,@PathVariable Integer userId, @PathVariable Integer categaryId  )
	{
		PostDto creaPost=this.postService.createPost(postDto, userId, categaryId);
		return new ResponseEntity<PostDto>(creaPost , HttpStatus.CREATED );
		
	}
	
	//get by userid
	
	@GetMapping("user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getByUSer(@PathVariable Integer userId){
		List<PostDto> posts=this.postService.getAllPostsByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(posts , HttpStatus.OK);
	}
	
	// get by categary
	
	@GetMapping("categary/{categaryId}/posts")
	public ResponseEntity<List<PostDto>> getByCategary(@PathVariable Integer categaryId)
	{
		List<PostDto> posts=this.postService.getAllPostsByCategory(categaryId);
		return new ResponseEntity<List<PostDto>>(posts , HttpStatus.OK);
		
	}
	
	//get all
	@GetMapping("/posts")
	public ResponseEntity<PostResponce> getAll(@RequestParam(value = "pageNumber" , defaultValue = "0" , required = false) Integer pageNumber,
			@RequestParam(value = "pageSize" , defaultValue = "10" , required = false)Integer pageSize , 
			@RequestParam(value = "sortBy" , defaultValue = "postId" ,required = false) String sortBy  ,
			@RequestParam(value = "sortDir" , defaultValue = "asc" , required = false )String sortdir){
		PostResponce posts=this.postService.getAllPost(pageNumber,pageSize , sortBy ,sortdir);
		return new ResponseEntity<PostResponce>(posts , HttpStatus.OK);
	}
	 
	//get single user
	@GetMapping("post/{postId}")
	public ResponseEntity<PostDto> getpost(@PathVariable Integer postId)
	{
	PostDto posts=this.postService.getPostById(postId);
	return new ResponseEntity<PostDto>(posts , HttpStatus.OK);
		
	}
	
	
	//delete
	@DeleteMapping("/post/{postId}")
	public ApiResponce deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		
		return new ApiResponce("Delete success" , true);
		
	}
	
	//update
//	@PutMapping("posts/{postId}")
//	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto , @PathVariable Integer postId)
//	{
//		PostDto updatePost = this.postService.updatePost(postDto, postId);
//		return new ResponseEntity<PostDto>(updatePost , HttpStatus.OK);
//	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto , @PathVariable Integer postId)
	{
		PostDto updated=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updated , HttpStatus.OK); 
	}
	
	//serch
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable("keywords") String keywords)
	{
		List<PostDto> results = this.postService.searchPosts(keywords);
		return new ResponseEntity<List<PostDto>>(results , HttpStatus.OK);
	}
	

}
