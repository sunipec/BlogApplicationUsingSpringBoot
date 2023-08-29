package com.springBoot.BlogApplication.springbootblogApplication.Service;

import java.util.List;

import com.springBoot.BlogApplication.springbootblogApplication.Entity.Posts;
import com.springBoot.BlogApplication.springbootblogApplication.Payload.PostDTO;

public interface PostService {

	PostDTO createPost(PostDTO postDto);
	
	List<PostDTO> getAllPosts();
	
	PostDTO getPostsById(long id);
	
	PostDTO updatePostById(long id,String title,  String description,String content);
	
	void deletePostById(long id);
	
}
