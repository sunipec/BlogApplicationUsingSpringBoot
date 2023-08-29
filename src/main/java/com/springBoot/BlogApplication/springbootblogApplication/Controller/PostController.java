package com.springBoot.BlogApplication.springbootblogApplication.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.BlogApplication.springbootblogApplication.Entity.Posts;
import com.springBoot.BlogApplication.springbootblogApplication.Payload.PostDTO;
import com.springBoot.BlogApplication.springbootblogApplication.Service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		
		this.postService = postService;
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto){
		return  new ResponseEntity<>(postService.createPost(postDto),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<PostDTO> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/{id}")
	public PostDTO getPostsById(@PathVariable("id") Long id){
		return postService.getPostsById(id);
	}
	
	@PostMapping("/update/{id}/{title}/{description}/{content}")
	public PostDTO updatePostsById(@PathVariable("id") Long id,@PathVariable("title") String title, @PathVariable("description") String description,@PathVariable("content") String content) {
		return postService.updatePostById(id,title, description,content);
	}
	
	@PostMapping("/delete/{id}")
	public void deletePostById(@PathVariable("id") Long id) {
		postService.deletePostById(id);
	}
	
	
}
