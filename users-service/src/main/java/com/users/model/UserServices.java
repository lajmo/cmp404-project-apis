package com.users.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices{
	enum Type{regular, admin}
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public User getUser(int id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User addRegularUser(User auser) {
		auser.setType(Type.regular.ordinal());
		return userRepo.save(auser);
	}
	
	public User addAdminUser(User auser) {
		auser.setType(Type.admin.ordinal());
		return userRepo.save(auser);
	}
	
	public User updateUser (User auser) {
		if(userRepo.existsById(auser.getId())) {
			userRepo.save(auser);
			return auser;
		}
		else {
			return null;
		}
	}
	
	public String removeUser(int id) {
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return "User Removed";
		}
		else {
			return "Error";
		}

	}

}