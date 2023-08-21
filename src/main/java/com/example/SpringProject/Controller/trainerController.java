package com.example.SpringProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringProject.Entity.Course;
import com.example.SpringProject.Entity.Lesson;
import com.example.SpringProject.Services.TrainerServices;

@Controller
public class trainerController {
	@Autowired

	TrainerServices tService;

	@PostMapping("/addCourse")
	public String addCourse(@RequestParam("course_id") int courseId, @RequestParam("course_name") String courseName,
			@RequestParam("course_price") int coursePrice) {
		Course course = new Course();
		course.setCourse_id(courseId);
		course.setCourse_name(courseName);
		course.setCourse_price(coursePrice);
		Course c = tService.addCourse(course);
		if (c != null) {
			return "/trainerLogin";
		} else {
			return "/addcoursefail";
		}
	}

	@PostMapping("/lesson")
	public String lesson(@RequestParam("course_id") int courseId, @RequestParam("lesson_id") int lessonId,
			@RequestParam("lesson_name") String lessonName, @RequestParam("link") String link,
			@RequestParam("topics") String topics) {
		Course course = tService.getCourse(courseId);
		Lesson lesson = new Lesson(lessonId, lessonName, link, topics, course);
		tService.addLesson(lesson);
		course.getLesson().add(lesson);
		tService.saveCourse(course);
		return "/trainerLogin";
	}

	@GetMapping("/showcourses")
	public String showCourses(Model model) {
		List<Course> courseList = tService.courseList();
		model.addAttribute("courseList", courseList);
		return "/viewcourse";
	}
}
