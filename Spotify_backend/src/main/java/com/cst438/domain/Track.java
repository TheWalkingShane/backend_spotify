package com.cst438.domain;

import java.util.List;

public class Track {
    private String id;
    private String name;
    private List<Artist> artists;
    private Album album;

    // Constructor
    public Track() {
        // Default constructor
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    // Inner class for Artist
    public static class Artist {
        private String id;
        private String name;

        // Constructors, getters and setters
    }

    // Inner class for Album
    public static class Album {
        private String id;
        private String name;

        // Constructors, getters and setters
    }
}

