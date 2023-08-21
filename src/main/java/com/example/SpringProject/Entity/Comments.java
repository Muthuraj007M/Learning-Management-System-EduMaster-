package com.example.SpringProject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int comment_id;
	String comments;

	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public Comments(int comment_id, String comments) {
		super();
		this.comment_id = comment_id;
		this.comments = comments;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", comments=" + comments + "]";
	}

	

}
