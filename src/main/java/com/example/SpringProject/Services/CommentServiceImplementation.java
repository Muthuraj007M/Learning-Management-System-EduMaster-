package com.example.SpringProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProject.DAOs.CommentRepository;
import com.example.SpringProject.Entity.Comments;

@Service
public class CommentServiceImplementation implements CommentServices {

	@Autowired
	CommentRepository commentRepo;

	@Override

	public List<Comments> commentList() {

		return commentRepo.findAll();

	}

	@Override

	public String addComment(Comments comment) {
		commentRepo.save(comment);
		return "comment added";

	}
}
