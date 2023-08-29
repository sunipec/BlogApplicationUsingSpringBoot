package com.springBoot.BlogApplication.springbootblogApplication.Service.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springBoot.BlogApplication.springbootblogApplication.Entity.Posts;
import com.springBoot.BlogApplication.springbootblogApplication.Payload.PostDTO;
import com.springBoot.BlogApplication.springbootblogApplication.Repository.PostRepository;
import com.springBoot.BlogApplication.springbootblogApplication.Service.PostService;


@Service
public class PostServiceImpl implements PostService {
	private PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		// TODO Auto-generated constructor stub
		this.postRepository = postRepository;
	}

	private Posts mapFromDTO(PostDTO postDto) {
		// DTO converted into entity
		Posts post = new Posts();
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());

		return post;
	}

	private PostDTO mapFromEntity(Posts post) {
		// convert entity to DTO
		PostDTO postResponse = new PostDTO();
		postResponse.setId(post.getId());
		postResponse.setTitle(post.getTitle());
		postResponse.setDescription(post.getDescription());
		postResponse.setContent(post.getContent());

		return postResponse;

	}

	public PostDTO createPost(PostDTO postDto) {

		
		Posts post = mapFromDTO(postDto);

		Posts postdto1 = postRepository.save(post);

		
		PostDTO postResponse = mapFromEntity(postdto1);

		return postResponse;
	}

	public List<PostDTO> getAllPosts() {
		List<Posts> post = postRepository.findAll();
		return post.stream().map(posts -> mapFromEntity(posts)).collect(Collectors.toList());
	}
	
	
	@Override
	public PostDTO getPostsById(long id) {
		Posts post= postRepository.findById(id).orElse(null);
		PostDTO postDto=mapFromEntity(post);
		return postDto;
	}
	
	@Override
	public PostDTO updatePostById(long id,String title,String desc, String content) {
		
//		
		Posts post=postRepository.findById(id).orElse(null);
		post.setContent(content);
		post.setTitle(title);
		post.setDescription(desc);
		
		Posts newPosts = postRepository.save(post);
		
		PostDTO postDto =mapFromEntity(newPosts);
		
		return postDto;
	}

	@Override
	public void deletePostById(long id) {
		
		postRepository.deleteById(id);
	}
	
	
}
