package com.cst438.domain;

public record TrackDTO(String id, String name, String artistNames, String albumName) {
    // The constructor can be omitted if the fields are directly mapped when creating the DTO instance
}