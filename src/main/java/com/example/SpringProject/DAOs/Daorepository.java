package com.example.SpringProject.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringProject.Entity.Users;

@Repository
public interface Daorepository extends JpaRepository<Users , Integer> {
	
	boolean existsByEmail(String email);
	
	Users getByEmail(String email);
	
	String getRoleByemail(String email);
}
