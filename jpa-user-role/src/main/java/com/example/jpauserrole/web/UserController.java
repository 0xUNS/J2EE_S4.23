package com.example.jpauserrole.web;

import com.example.jpauserrole.entities.User;
import com.example.jpauserrole.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/users/{username}")
	public User user(@PathVariable String username) {
		User user = userService.findUserByUserName(username);
		return user;
	}
}
