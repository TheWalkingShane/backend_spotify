package com.cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cst438.domain.UserProfile;
import com.cst438.domain.UserRepository;

@RestController
@CrossOrigin
public class UserProfileController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/profile")
	public ResponseEntity<UserProfile> getUserProfile(@RequestParam String user_id) {
		UserProfile userProfile = userRepository.findByUsername(user_id);
		return ResponseEntity.ok(userProfile);
	}
}
