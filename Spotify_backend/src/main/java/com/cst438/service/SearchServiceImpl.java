package com.cst438.service;

import com.cst438.controller.SearchService;
import com.cst438.controller.SpotifySearchResponse;
import com.cst438.domain.TrackDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import javax.sound.midi.Track;

@Service
public class SearchServiceImpl implements SearchService {

    private final RestTemplate restTemplate;

    public SearchServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Track> searchTracks(String query, String accessToken) {
        String url = "https://api.spotify.com/v1/search?q=" + query + "&type=track";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        
        ResponseEntity<SpotifySearchResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, SpotifySearchResponse.class);

        // Assuming SpotifySearchResponse has a structure that includes a list of track items
        // and that these items can be directly mapped to TrackDTO objects
        return null;
    }


    @Override
    public boolean addTrack(TrackDTO trackDTO, String accessToken) {
        String url = "https://api.spotify.com/v1/me/tracks";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);
        String trackIdJson = "{\"ids\": [\"" + trackDTO + "\"]}";
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
		// TODO Auto-generated method stub
		return false;
	}


    // Additional methods and logic as needed
}

