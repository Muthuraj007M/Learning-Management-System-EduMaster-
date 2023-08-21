package com.example.SpringProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringProject.Entity.Comments;
import com.example.SpringProject.Entity.Course;
import com.example.SpringProject.Entity.Lesson;
import com.example.SpringProject.Entity.Users;
import com.example.SpringProject.Services.CommentServices;
import com.example.SpringProject.Services.StudentServices;
import com.example.SpringProject.Services.TrainerServices;
import com.example.SpringProject.Services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class studentController {

	@Autowired
	StudentServices service;

	@Autowired
	CommentServices cService;

	@Autowired
	UserServices us;
	
	@Autowired
	TrainerServices ts;

	@GetMapping("/fetchCourses")

	public String fetchCourses(Model model, HttpSession session) {

		Users loggedUser = (Users) session.getAttribute("loggedInUser");

		String email = loggedUser.getEmail();
		Users user = us.getUser(email);

		List<Course> courseList = user.getCourse();

		model.addAttribute("courseList", courseList);

		return "/myCourses";

	}

	@GetMapping("/viewLesson")

	public String viewLesson(@RequestParam("lesson_id") int lessonId,

			Model model, HttpSession session) {

		// Users user = (Users) session.getAttribute("loggedInUser");

		Lesson lesson = service.getLesson(lessonId);

		// Extract the YouTube video id from the URL

		String youtubeUrl = lesson.getLink();

		String videoId = youtubeUrl.substring(youtubeUrl.indexOf("=") + 1);

		lesson.setLink(videoId);

		model.addAttribute("lesson", lesson);

		List<Comments> commentsList = cService.commentList();

		model.addAttribute("comments", commentsList);

		return "myLesson";

	}
	
	@PostMapping("/addComment")
	public String comments(@RequestParam("comment")String comment
						,Model model) {
		Comments c=new Comments();
		c.setComments(comment);
		cService.addComment(c);
		
		List<Comments> commentsList=cService.commentList();
		model.addAttribute("comments",commentsList);
		
		return "myLesson";
	}

	@GetMapping("/purchase")
	public String showCourses(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("loggedInUser");

		List<Course> courseList = ts.courseList();
		
		model.addAttribute("courseList", courseList);
		
		model.addAttribute("loggedInUser", user);
		
		return "purchasecourse";
	}
}
