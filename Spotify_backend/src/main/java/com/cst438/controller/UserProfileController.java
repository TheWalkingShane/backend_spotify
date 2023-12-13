package com.cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cst438.domain.UserProfile;
import com.cst438.domain.UserRepository;
import com.cst438.domain.UserProfileDTO;

@RestController
@CrossOrigin
public class UserProfileController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/profile")
	public UserProfileDTO getUserProfile(@RequestParam String user_id) {
		UserProfile userProfile = userRepository.findByUsername(user_id);
		if (userProfile != null) {
			UserProfileDTO userDTO = new UserProfileDTO(
					userProfile.getUsername(), 
					userProfile.getAccess_token(), 
					userProfile.getRefresh_token(), 
					userProfile.getExpires_in());
			return userDTO;
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found!");
	}
	
	@PostMapping("/profile/new")
	public UserProfileDTO createUserProfile(@RequestParam("user_id") String user_id, 
			@RequestParam("access_token") String access_token, 
			@RequestParam("refresh_token") String refresh_token, 
			@RequestParam("expires_in") int expires_in) {
		
		if (userRepository.findByUsername(user_id) != null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists!");
		}

		UserProfile user = new UserProfile();
		user.setUsername(user_id);
		user.setAccess_token(access_token);
		user.setRefresh_token(refresh_token);
		user.setExpires_in(expires_in);
		userRepository.save(user);
		UserProfileDTO userDTO = new UserProfileDTO(user_id, access_token, refresh_token, expires_in);
		return userDTO;
	}
	
	@PutMapping("/profile/refresh")
	@Transactional
	public UserProfileDTO updateUserProfile(@RequestParam("user_id") String user_id, 
			@RequestParam("access_token") String access_token, 
			@RequestParam("refresh_token") String refresh_token, 
			@RequestParam("expires_in") int expires_in) {
		UserProfile user = userRepository.findByUsername(user_id);
		if (user != null) {
			user.setAccess_token(access_token);
			user.setRefresh_token(refresh_token);
			user.setExpires_in(expires_in);
			userRepository.save(user);
			UserProfileDTO userDTO = new UserProfileDTO(user_id, access_token, refresh_token, expires_in);
			return userDTO;
		}
		
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not find user with that ID");
	}
}
