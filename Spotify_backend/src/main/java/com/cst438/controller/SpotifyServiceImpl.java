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
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<UserProfile> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, UserProfile.class);

        return response.getBody();
    }
/*    @Override
    public List<TrackDTO> searchTracks(String query, String accessToken) {
        try {
            String url = "https://api.spotify.com/v1/search?q=" + query + "&type=track";
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            HttpEntity<?> entity = new HttpEntity<>(headers);

            ResponseEntity<SearchResponse> response = restTemplate.exchange(
                    url, HttpMethod.GET, entity, SearchResponse.class);

            return response.getBody().getTracks().getItems().stream() // still having errors
                    .map(track -> new TrackDTO(track.getId(), track.getName(), ...)) // Map other necessary fields
                    .collect(Collectors.toList());
        } catch (HttpClientErrorException e) {
            // Handle error scenarios, like unauthorized access or bad requests
            throw new RuntimeException("Error fetching tracks: " + e.getMessage());
        }
    }*/

}


