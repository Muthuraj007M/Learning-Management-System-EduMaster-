package com.example.SpringProject.Services;

import java.util.List;

import com.example.SpringProject.Entity.Comments;

public interface CommentServices {

	List<Comments> commentList();

	String addComment(Comments comment);
}
