package com.apis.services;

import com.apis.payloads.CommentDto;

public interface CommentServise {
	
	//create
	CommentDto createCommet(CommentDto commentDto , Integer postId);
	
	//delete
	void deleteComment(Integer id);
	

}
