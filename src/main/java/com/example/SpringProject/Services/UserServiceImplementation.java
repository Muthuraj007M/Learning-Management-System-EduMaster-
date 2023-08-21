package com.example.SpringProject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringProject.DAOs.Daorepository;
import com.example.SpringProject.Entity.Users;

@Service
public class UserServiceImplementation implements UserServices {

	Daorepository dr;

	@Autowired
	public UserServiceImplementation(Daorepository dr) {
		this.dr = dr;
	}

	@Override
	public boolean checkEmail(String email) {
		boolean res = dr.existsByEmail(email);
		return res;
	}

	@Override
	public String addUser(Users user) {
		dr.save(user);
		return "Registration Successful";

	}

	@Override

	public boolean validate(String email, String password) {

		if (dr.existsByEmail(email)) {

			Users u = dr.getByEmail(email);

			String dbPassword = u.getPassword();

			if (password.equals(dbPassword)) {

				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override

	public String getUserRole(String email) {

		Users u = dr.getByEmail(email);
		return u.getRole();

	}

	@Override

	public Users getUser(String email) {
		return dr.getByEmail(email);
	}
	
	@Override
	public String updateUser(Users user) {
		dr.save(user);
		return "student updated successfully!";
	}
}
