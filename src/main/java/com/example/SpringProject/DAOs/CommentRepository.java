package com.example.SpringProject.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringProject.Entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
