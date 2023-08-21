package com.example.SpringProject.Services;

import com.example.SpringProject.Entity.Users;

public interface UserServices {
	
	public boolean checkEmail(String email);
	
	public String addUser(Users user);
	//validates user's credentials

	boolean validate(String email, String password);

	Users getUser(String email);

	String getUserRole(String email);
	
    String updateUser(Users user); 
}
