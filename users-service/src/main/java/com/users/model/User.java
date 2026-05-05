package com.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer type;
	//enum Types {regular, admin};
	private String username;
	private String password;
	
	public User(){};
	public User(Integer id, Integer type, String username, String password) {
		this.id = id;
		this.type = type;
		this.username = username;
		this.password = password;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
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