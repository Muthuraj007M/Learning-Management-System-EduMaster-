package com.example.SpringProject.Services;

import java.util.List;

import com.example.SpringProject.Entity.Course;
import com.example.SpringProject.Entity.Lesson;

public interface TrainerServices {

	public Course addCourse(Course course);

	public String saveCourse(Course course);

	public String addLesson(Lesson lesson);

	public Course getCourse(int courseId);

	public List<Course> courseList();
}
