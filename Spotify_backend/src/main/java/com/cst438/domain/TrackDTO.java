package com.cst438.domain;


public record TrackDTO(String id, String name, String artist, String album, int durationMs) {
    // The record constructor and methods are implicitly defined.
}
