package com.cst438.controller;

import java.util.List;

public class SpotifySearchResponse {
	private SpotifyTracks tracks;

    public SpotifyTracks getTracks() {
        return tracks;
    }

    public static class SpotifyTracks {
        private List<SpotifyTrackItem> items;

        public List<SpotifyTrackItem> getItems() {
            return items;
        }
    }

    public static class SpotifyTrackItem {
        private String id;
        private String name;
        private List<SpotifyArtist> artists;
        private SpotifyAlbum album;

        // Getters for SpotifyTrackItem
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<SpotifyArtist> getArtists() {
            return artists;
        }

        public SpotifyAlbum getAlbum() {
            return album;
        }

        public static class SpotifyArtist {
            private String name;

            // Getter for SpotifyArtist
            public String getName() {
                return name;
            }
        }

        public static class SpotifyAlbum {
            private String name;

            // Getter for SpotifyAlbum
            public String getName() {
                return name;
            }
        }
    }
}
