package com.cst438.controller;

import com.cst438.domain.PlaylistDTO;
import com.cst438.domain.TrackDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String spotifyApiBaseUrl = "https://api.spotify.com/v1"; // Base URL for Spotify API

    // Example endpoint to get a track by its ID
    @GetMapping("/track/{id}")
    public TrackDTO getTrack(@PathVariable String id) {
        System.out.println("get track");
        String url = spotifyApiBaseUrl + "/tracks/" + id;
        // Include necessary headers, e.g., for authentication
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        // Parse response to create TrackDTO
        // Return the TrackDTO
    }

    // Example endpoint to get a playlist by its ID
    @GetMapping("/playlist/{id}")
    public PlaylistDTO getPlaylist(@PathVariable String id) {
        System.out.println("get playlist");
        String url = spotifyApiBaseUrl + "/playlists/" + id;
        // Include necessary headers, e.g., for authentication
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        // Parse response to create PlaylistDTO
        // Return the PlaylistDTO
    }

    // Example endpoint to add a track to a playlist
    @PostMapping("/playlist/{playlistId}/add/{trackId}")
    public void addTrackToPlaylist(@PathVariable String playlistId, @PathVariable String trackId) {
        System.out.println("add track to playlist");
        String url = spotifyApiBaseUrl + "/playlists/" + playlistId + "/tracks";
        // Construct the request body (e.g., the track URI)
        // Include necessary headers, e.g., for authentication
        restTemplate.postForEntity(url, request, String.class);
    }

    // Example endpoint to remove a track from a playlist
    @DeleteMapping("/playlist/{playlistId}/remove/{trackId}")
    public void removeTrackFromPlaylist(@PathVariable String playlistId, @PathVariable String trackId) {
        System.out.println("remove track from playlist");
        String url = spotifyApiBaseUrl + "/playlists/" + playlistId + "/tracks";
        // Construct the removal request (e.g., track URI and positions)
        // Include necessary headers, e.g., for authentication
        restTemplate.delete(url);
    }

    // Additional helper methods to parse API responses and construct DTOs can be added here
}

