package com.cst438.domain;
import java.util.List;

public record PlaylistDTO(String id, String name, List<TrackDTO> tracks) {
    // Similarly, this record handles the data structure for a playlist.
}

