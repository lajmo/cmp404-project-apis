package com.users.users_service;

public class SessionResponse {
	private boolean authenticated;
	private Integer userId;
	private String username;
	private Integer type;
	private String message;

	public SessionResponse(boolean authenticated, Integer userId, String username, Integer type, String message) {
		this.authenticated = authenticated;
		this.userId = userId;
		this.username = username;
		this.type = type;
		this.message = message;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public Integer getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}
}
