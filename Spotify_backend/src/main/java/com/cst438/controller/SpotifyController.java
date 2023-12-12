package com.cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {

    private final SpotifyService spotifyService;

    @Autowired
    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    @GetMapping("/user-profile")
    public ResponseEntity<UserProfile> getUserProfile(@RequestHeader("Authorization") String accessToken) {
        try {
            UserProfile userProfile = spotifyService.getUserProfile(accessToken);
            return ResponseEntity.ok(userProfile);
        } catch (Exception e) {
            // Handle exceptions like invalid token, service unavailability, etc.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Consider a more specific error handling strategy
        }
    }
}




