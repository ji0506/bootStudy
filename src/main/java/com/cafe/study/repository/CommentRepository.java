package com.cafe.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe.study.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	
	
	
}
