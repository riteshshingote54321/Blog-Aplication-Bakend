package com.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.payloads.ApiResponce;
import com.apis.payloads.CommentDto;
import com.apis.services.CommentServise;
;

@RestController
@RequestMapping("/api/")
public class CommentController {
	
	@Autowired
	private CommentServise commentServise;
	
	@PostMapping("/post/{postId}/comment")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto , @PathVariable Integer postId)
	{
		CommentDto createCommet=this.commentServise.createCommet(commentDto, postId);
		
		return new ResponseEntity<>(createCommet , HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponce> deleteComment(@PathVariable Integer id)
	{
		this.commentServise.deleteComment(id);
		return new ResponseEntity<ApiResponce>(new ApiResponce("User Delete success" ,true) ,HttpStatus.OK);
		
	}

}
