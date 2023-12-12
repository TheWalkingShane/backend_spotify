package com.cst438.controller;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cst438.domain.TrackDTO;

import java.util.List;

@Service
public class SpotifyServiceImpl implements SpotifyService {

    private final RestTemplate restTemplate;

    public SpotifyServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public UserProfile getUserProfile(String accessToken) {
        String url = "https://api.spotify.com/v1/me";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<UserProfile> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, UserProfile.class);

        return response.getBody();
    }

    public List<TrackDTO> searchTracks(String query, String accessToken) {
        // Implement search logic
        // Return List<TrackDTO>
        return null;
    }

    public boolean addTrack(TrackDTO trackDTO, String accessToken) {
        // Implement logic to add a track
        return false;
    }

    public boolean deleteTrack(String trackId, String accessToken) {
        // Implement logic to delete a track
        return false;
    }

    public boolean updateTrack(String trackId, TrackDTO trackDTO, String accessToken) {
        // Implement logic to update a track
        return false;
    }
}



