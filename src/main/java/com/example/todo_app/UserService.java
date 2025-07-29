package com.example.todo_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) throws Exception {
		// Email already registered hai kya?
		if (userRepository.findByEmail(user.getEmail()) != null) {
			throw new Exception("Email already registered!");
	}
		if (userRepository.findByUsername(user.getUsername()) != null) {
			throw new Exception("Username already taken!");
		}
		return userRepository.save(user);
	}
}