package com.cst438.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpotifyServiceImpl implements SpotifyService {

    private final RestTemplate restTemplate;

    public SpotifyServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public UserProfile getUserProfile(String accessToken) {
        String url = "https://api.spotify.com/v1/me";
        // Set up headers with the access token
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<UserProfile> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, UserProfile.class);

        return response.getBody();
    }
}
