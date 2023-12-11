package com.cst438.controller;


import java.util.List;

import com.cst438.domain.TrackDTO;

public class SpotifySearchResponse {
    private SpotifyTracks tracks;

    public SpotifyTracks getTracks() {
        return tracks;
    }

    public static class SpotifyTracks {
        private List<TrackDTO> items;

        public List<TrackDTO> getItems() {
            return items;
        }
    }
}

