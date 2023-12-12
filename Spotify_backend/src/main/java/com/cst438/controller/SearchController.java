package com.cst438.controller;

import com.cst438.domain.TrackDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.sound.midi.Track;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public ResponseEntity<List<Track>> searchTracks(@RequestParam String query, @RequestParam String accessToken) {
        List<Track> trackDTOs = searchService.searchTracks(query, accessToken);
        return ResponseEntity.ok(trackDTOs);
    }

    @PostMapping
    public ResponseEntity<?> addTrack(@RequestBody TrackDTO trackDTO, @RequestParam String accessToken) {
        boolean isAdded = searchService.addTrack(trackDTO, accessToken);
        if (isAdded) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Track could not be added");
        }
    }

    @DeleteMapping("/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable String trackId, @RequestParam String accessToken) {
        boolean isDeleted = searchService.deleteTrack(trackId, accessToken);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Track could not be deleted");
        }
    }

    @PutMapping("/{trackId}")
    public ResponseEntity<?> updateTrack(@PathVariable String trackId, @RequestBody TrackDTO trackDTO, @RequestParam String accessToken) {
        boolean isUpdated = searchService.updateTrack(trackId, trackDTO, accessToken);
        if (isUpdated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Track could not be updated");
        }
    }

    // Additional methods for other functionalities can be added here
}
