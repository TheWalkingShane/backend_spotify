package com.cst438.service;  // Adjust the package if necessary

import com.cst438.domain.TrackDTO;
import java.util.List;

public interface SearchService {
    List<TrackDTO> searchTracks(String query, String accessToken);
    boolean addTrack(TrackDTO trackDTO, String accessToken);
    boolean deleteTrack(String trackId, String accessToken);
    boolean updateTrack(String trackId, TrackDTO trackDTO, String accessToken);
    
    // Additional methods for other search types can be added here
}
