package com.example.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.entities.Comment;
import com.example.blog.entities.Post;
import com.example.blog.entities.User;
import com.example.blog.exception.ApiException;
import com.example.blog.exceptions.ResourceNotFoundException;
import com.example.blog.payloads.ApiResponse;
import com.example.blog.payloads.CommentDto;
import com.example.blog.repositories.CommentRepo;
import com.example.blog.repositories.PostRepo;
import com.example.blog.repositories.UserRepo;
import com.example.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto comentDto, Integer postId, Integer userId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user id", userId));
		Comment comment = this.modelMapper.map(comentDto, Comment.class);
		comment.setPost(post);
		comment.setUser(user);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId, Integer userId) {
		
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "comment id", commentId));
        if(comment.getUser().getId() != userId) {
        	throw new ApiException("You are not allowed to delete this comment!");
        }
        
		this.commentRepo.delete(comment);

	}

	

}
