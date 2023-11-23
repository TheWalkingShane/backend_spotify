package com.cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    private final SpotifyService spotifyService;

    @Autowired
    public UserProfileController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfile> getUserProfile(@RequestParam String accessToken) {
        UserProfile userProfile = spotifyService.getUserProfile(accessToken);
        return ResponseEntity.ok(userProfile);
    }
}
