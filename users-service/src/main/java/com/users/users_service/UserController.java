package com.users.users_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.model.User;
import com.users.model.UserServices;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserServices userService;
	
	@GetMapping
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping(path = "{userid}")
	public User getUser(@PathVariable("userid") int id) {
		return userService.getUser(id);
	}

	@PostMapping
	public User addRegularUser(@RequestBody User auser) {
		return userService.addRegularUser(auser);
	}
	
	@PostMapping
	public User addAdminUser(@RequestBody User auser) {
		return userService.addAdminUser(auser);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User auser) {
		return userService.updateUser(auser);
	}
	
	@DeleteMapping(path = "{userid}")
	public String deleteHost(@PathVariable("userid") int id) {
		return userService.removeUser(id);
	}
	
}