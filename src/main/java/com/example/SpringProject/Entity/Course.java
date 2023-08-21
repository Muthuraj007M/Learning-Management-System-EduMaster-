package com.example.SpringProject.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Course {

	@Id
	int course_id;
	String course_name;
	int course_price;
	@OneToMany
	List<Lesson>lesson;
	@ManyToMany
	List<Users> userList;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int course_id, String course_name, int course_price, List<Lesson> lesson, List<Users> userList) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_price = course_price;
		this.lesson = lesson;
		this.userList = userList;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getCourse_price() {
		return course_price;
	}

	public void setCourse_price(int course_price) {
		this.course_price = course_price;
	}

	public List<Lesson> getLesson() {
		return lesson;
	}

	public void setLesson(List<Lesson> lesson) {
		this.lesson = lesson;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_price=" + course_price
				+ ", lesson=" + lesson + ", userList=" + userList + "]";
	}
	
}
