package com.example.SpringProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProject.Controller.trainerController;
import com.example.SpringProject.DAOs.Daorepository;
import com.example.SpringProject.DAOs.LessonRepository;
import com.example.SpringProject.Entity.Course;
import com.example.SpringProject.Entity.Lesson;

@Service
public class StudentServiceImplementation implements StudentServices {

	@Autowired
	Daorepository dr;

	@Autowired
	LessonRepository lessonRepo;
	
	trainerController tr;

	@Override

	public Lesson getLesson(int lessonId) {

		return lessonRepo.findById(lessonId).get();

	}

	@Override
	public List<Course> getCourses() {
		
		return null;
	}
}
