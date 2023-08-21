package com.example.SpringProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProject.DAOs.CourseRepository;
import com.example.SpringProject.DAOs.LessonRepository;
import com.example.SpringProject.Entity.Course;
import com.example.SpringProject.Entity.Lesson;

@Service
public class TrainerServiceImplementation implements TrainerServices {

	@Autowired
	CourseRepository courseRepo;

	@Override

	public Course addCourse(Course course) {

		return courseRepo.save(course);

	}

	@Autowired
	LessonRepository lessonRepo;

	@Override

	public String addLesson(Lesson lesson) {
		lessonRepo.save(lesson);
		return "lesson added successfully!";
	}

	@Override

	public Course getCourse(int courseId) {

		return courseRepo.findById(courseId).get();
	}

	@Override
	public List<Course> courseList() {

		List<Course> courselist = courseRepo.findAll();
		return courselist;
	}

	@Override
	public String saveCourse(Course course) {
		courseRepo.save(course);
		return "Course saved successfully!";
	}
}
