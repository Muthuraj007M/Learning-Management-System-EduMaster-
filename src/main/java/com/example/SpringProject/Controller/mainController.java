package com.example.SpringProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringProject.Entity.Users;
import com.example.SpringProject.Services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/lms")
public class mainController {

	UserServices ref;

	@Autowired
	public mainController(UserServices ref) {
		this.ref = ref;
	}

	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/register")
	public String registering() {
		return "register";
	}

	@GetMapping("/failRegister")
	public String failRegistering() {
		return "failRegister";
	}

	@GetMapping("/failLogin")
	public String failLogin() {
		return "failLogin";
	}

	@GetMapping("/studentLogin")
	public String studentLogin() {
		return "studentLogin";
	}

	@GetMapping("/trainerLogin")
	public String trainerLogin() {
		return "trainerLogin";
	}

	@GetMapping("/addcourse")
	public String addcourses() {
		return "addcourse";
	}

	@GetMapping("/addlesson")
	public String addlessons() {
		return "addlesson";
	}

	@GetMapping("/viewcourse")
	public String viewcourse() {
		return "viewcourse";
	}

	@PostMapping("/adduser")
	public String addusers(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("role") String role) {
		boolean exists = ref.checkEmail(email);
		if (exists == false) {
			Users u = new Users();
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);
			u.setRole(role);
			ref.addUser(u);
			System.out.println("Registration Successfull");
			return "redirect:/lms/home";
		}
		return "redirect:/lms/failRegister";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		if (ref.checkEmail(email)) {
			boolean val = ref.validate(email, password);
			// if user is valid
			if (val == true) {
				Users user = ref.getUser(email); // Assuming you have a method to get the User object
				session.setAttribute("loggedInUser", user); // Saving the User object in session
				if (ref.getUserRole(email).equals("trainer")) {
					return "trainerLogin";
				} else {
					return "studentLogin";
				}
			} else {
				System.out.println("incorrect credentials, try again!");
				return "failLogin";
			}
		} else {
			return "index";
		}
	}
}
