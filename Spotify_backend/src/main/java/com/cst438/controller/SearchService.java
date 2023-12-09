package com.cst438.controller;

import java.util.List;

import javax.sound.midi.Track;

public interface SearchService {
    List<Track> searchTracks(String query, String accessToken);
    // You can add more methods for different types of searches, like albums, artists, etc.
}
