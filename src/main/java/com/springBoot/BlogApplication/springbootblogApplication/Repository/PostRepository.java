package com.springBoot.BlogApplication.springbootblogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.BlogApplication.springbootblogApplication.Entity.Posts;

public interface PostRepository extends JpaRepository<Posts, Long> { // long is the primary key type and Posts is a
																		// table or class name

}
