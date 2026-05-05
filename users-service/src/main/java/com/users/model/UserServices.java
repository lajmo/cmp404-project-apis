package com.users.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices{
	
	@Autowired
	private UserRepository userRepo;
	
	enum Type{regular, admin}
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public User getUser(int id) {
		return userRepo.findById(id).orElse(null);
	}

	public Optional<User> authenticate(String username, String password) {
		return userRepo.findByUsernameAndPassword(username, password);
	}
	
	public User addUser(User auser) {
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
