package com.cst438.service;

import com.cst438.controller.SpotifySearchResponse;
import com.cst438.domain.TrackDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    private final RestTemplate restTemplate;

    public SearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<TrackDTO> searchTracks(String query, String accessToken) {
        String url = "https://api.spotify.com/v1/search?q=" + query + "&type=track";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<SpotifySearchResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, SpotifySearchResponse.class);


        return response.getBody().getTracks().getItems().stream()
        	    .map(item -> new TrackDTO(
        	        item.getId(), 
        	        item.getName(), 
        	        item.getArtists().stream().map(SpotifySearchResponse.SpotifyTrackItem.SpotifyArtist::getName).collect(Collectors.joining(", ")), 
        	        item.getAlbum().getName()))
        	    .collect(Collectors.toList());

    }

    @Override
    public boolean addTrack(TrackDTO trackDTO, String accessToken) {
        String url = "https://api.spotify.com/v1/me/tracks";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        String trackIdJson = "{\"ids\": [\"" + trackDTO.getId() + "\"]}";
        HttpEntity<String> entity = new HttpEntity<>(trackIdJson, headers);
        ResponseEntity<?> response = restTemplate.postForEntity(url, entity, Void.class);

        return response.getStatusCode().is2xxSuccessful();
    }

    @Override
    public boolean deleteTrack(String trackId, String accessToken) {
        String url = "https://api.spotify.com/v1/me/tracks?ids=" + trackId;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<?> response = restTemplate.exchange(
                url, HttpMethod.DELETE, entity, Void.class);

        return response.getStatusCode().is2xxSuccessful();
    }

    @Override
    public boolean updateTrack(String trackId, TrackDTO trackDTO, String accessToken) {
        // Implement if updating tracks is supported and required
        return false;
    }

    // Additional methods and logic as needed
}


