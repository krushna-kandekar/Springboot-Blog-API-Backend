package com.example.blog.services;

import com.example.blog.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto comentDto, Integer postId);
	
	void deleteComment(Integer commentId);
}
