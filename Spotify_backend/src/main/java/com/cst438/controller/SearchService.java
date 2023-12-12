package com.cst438.controller;

import java.util.List;

import javax.sound.midi.Track;

import com.cst438.domain.TrackDTO;

public interface SearchService {
    List<Track> searchTracks(String query, String accessToken);    
    boolean addTrack(TrackDTO trackDTO, String accessToken);
    boolean deleteTrack(String trackId, String accessToken);
    boolean updateTrack(String trackId, TrackDTO trackDTO, String accessToken);
    
    // You can add more methods for different types of searches, like albums, artists, etc.
}
