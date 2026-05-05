package com.users.users_service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users.model.User;
import com.users.model.UserServices;

@CrossOrigin(origins = {"http://localhost:4173", "http://127.0.0.1:4173", "http://localhost:5173", "http://127.0.0.1:5173"})
@RestController
@RequestMapping("/sessions")
public class SessionController {

	@Autowired
	private UserServices userService;

	@PostMapping
	public ResponseEntity<SessionResponse> login(@RequestBody SessionRequest request) {
		Optional<User> user = userService.authenticate(request.getUsername(), request.getPassword());

		if (user.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body(new SessionResponse(false, null, null, null, "Invalid username or password"));
		}

		User authenticatedUser = user.get();
		return ResponseEntity.ok(new SessionResponse(
				true,
				authenticatedUser.getId(),
				authenticatedUser.getUsername(),
				authenticatedUser.getType(),
				"Login successful"));
	}
}
