package com.example.SpringProject.Services;

import java.util.List;

import com.example.SpringProject.Entity.Course;
import com.example.SpringProject.Entity.Lesson;

public interface StudentServices {

	Lesson getLesson(int lessonId);
	List<Course> getCourses();
}
