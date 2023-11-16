package com.cst438;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cst438.domain.PlaylistDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class JunitTestSpotify {

    @Autowired
    private MockMvc mvc;

    // Example test: Add a track to a playlist
    @Test
    public void addTrackToPlaylistTest() throws Exception {
        MockHttpServletResponse response;

        // Simulate a POST request to add a track to a playlist
        response = mvc.perform(
                        MockMvcRequestBuilders
                                .post("/spotify/playlist/1/add/123")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify that the response status is OK (200)
        assertEquals(200, response.getStatus());

        // Additional assertions can be added here...
    }

    // Example test: Get a playlist
    @Test
    public void getPlaylistTest() throws Exception {
        MockHttpServletResponse response;

        // Simulate a GET request to retrieve a playlist
        response = mvc.perform(
                        MockMvcRequestBuilders
                                .get("/spotify/playlist/1")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify that the response status is OK (200)
        assertEquals(200, response.getStatus());

        // Verify the playlist content
        PlaylistDTO playlist = fromJsonString(response.getContentAsString(), PlaylistDTO.class);
        assertNotNull(playlist, "Playlist not found");

        // Additional assertions can be added here...
    }

    // JSON utility methods
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T fromJsonString(String str, Class<T> valueType) {
        try {
            return new ObjectMapper().readValue(str, valueType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
