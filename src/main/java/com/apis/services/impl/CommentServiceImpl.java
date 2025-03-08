package com.apis.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.entites.Comment;
import com.apis.entites.Post;
import com.apis.exceptions.ResourceNotFoundException;
import com.apis.payloads.CommentDto;
import com.apis.repositarys.PostRepo;
import com.apis.repositarys.commentRepo;
import com.apis.services.CommentServise;

@Service
public class CommentServiceImpl implements CommentServise {
	
	@Autowired
	private commentRepo commentRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createCommet(CommentDto commentDto,Integer postId ) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
		Comment comments = this.modelMapper.map(commentDto, Comment.class);
		comments.setPost(post);
		Comment save = this.commentRepo.save(comments);
		
		return this.modelMapper.map(save, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer id) {
		Comment cam=this.commentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Commnet", "id", id));
		this.commentRepo.delete(cam);

	}

}
