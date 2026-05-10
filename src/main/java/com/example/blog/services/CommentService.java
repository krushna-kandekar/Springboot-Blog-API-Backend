package com.example.blog.services;

import com.example.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto comentDto, Integer postId, Integer userId);
	
	void deleteComment(Integer commentId, Integer userId);
	
}
