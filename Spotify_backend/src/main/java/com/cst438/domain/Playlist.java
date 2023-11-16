package com.cst438.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    private String id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "playlist_track",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private List<Track> tracks;

    // Constructors
    public Playlist() {}

    public Playlist(String id, String name, List<Track> tracks) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
    }

    // Getters and setters
    // ... (omitted for brevity)

}
