package com.cst438.domain;

import java.util.stream.Collectors;

public record TrackDTO(String id, String name, String artistNames, String albumName) {
    // The constructor can be omitted if the fields are directly mapped when creating the DTO instance
}


