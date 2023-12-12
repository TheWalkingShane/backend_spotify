package com.cst438.domain;

public class TrackDTO {
    private String id;
    private String name;
    private String artistNames;
    private String albumName;

    // Constructor
    public TrackDTO(String id, String name, String artistNames, String albumName) {
        this.id = id;
        this.name = name;
        this.artistNames = artistNames;
        this.albumName = albumName;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtistNames() {
        return artistNames;
    }

    public String getAlbumName() {
        return albumName;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistNames(String artistNames) {
        this.artistNames = artistNames;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
