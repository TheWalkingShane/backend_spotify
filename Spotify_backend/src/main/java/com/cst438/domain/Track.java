package com.cst438.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "track")
public class Track {

    @Id
    private String id;
    private String name;
    private String artist;
    private String album;
    private int durationMs;

    // Constructors
    public Track() {}

    public Track(String id, String name, String artist, String album, int durationMs) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.durationMs = durationMs;
    }

    // Getters and setters
    // ... (omitted for brevity)

}

