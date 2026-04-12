package com.users.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int type;
	enum Types {regular, admin};
	private String username;
	private String password;
	
	public User(){};
	public User(int id, int type, String username, String password) {
		this.id = id;
		this.type = type;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getType() {
		return this.type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String Username) {
		this.username = Username;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String Password) {
		this.password = Password;
	}
}