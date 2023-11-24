package com.cst438.controller;

import javax.sound.midi.Track;
import java.util.List;

public interface SearchService {
    List<Track> searchTracks(String query, String accessToken);
    // You can add more methods for different types of searches, like albums, artists, etc.
}
