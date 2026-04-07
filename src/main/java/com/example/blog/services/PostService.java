package com.example.blog.services;

import java.util.List;

import com.example.blog.entities.Post;
import com.example.blog.payloads.PostDto;
import com.example.blog.payloads.PostResponse;

public interface PostService {

	
	//create
	   
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all posts
	
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all posts by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//search post
	
	List<Post> searchPost(String keyword);
}
