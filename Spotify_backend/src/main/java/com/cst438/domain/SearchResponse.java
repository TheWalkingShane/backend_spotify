package com.cst438.domain;

import java.util.List;

public class SearchResponse {
    private SpotifyTracks tracks;

    public SpotifyTracks getTracks() {
        return tracks;
    }

    public static class SpotifyTracks {
        private List<Track> items;

        public List<Track> getItems() {
            return items;
        }
    }
}

