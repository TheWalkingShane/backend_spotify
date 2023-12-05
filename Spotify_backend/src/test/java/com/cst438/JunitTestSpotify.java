package com.cst438;


import com.cst438.controller.*;
import com.cst438.domain.TrackDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest({SpotifyController.class, SearchController.class})
public class JunitTestSpotify {

    // Inject MockMvc for testing controllers
    @Autowired
    private MockMvc mockMvc;

    // Mock Beans for service layer used in controllers
    @MockBean
    private SpotifyService spotifyService;
    @MockBean
    private SearchService searchService;

    // Mock for RestTemplate used in SpotifyServiceImpl
    @Mock
    private RestTemplate restTemplate;

    // InjectMocks for testing SpotifyServiceImpl
    @InjectMocks
    private SpotifyServiceImpl spotifyServiceMock;

    // ====================== SpotifyServiceImpl Tests ======================

    @Test
    public void testGetUserProfile_SpotifyServiceImpl() {
        // Arrange
        String accessToken = "testToken";
        String url = "https://api.spotify.com/v1/me";
        UserProfile mockResponse = new UserProfile();

        mockResponse.setId("12345");
        mockResponse.setDisplayName("Test User");


        when(restTemplate.exchange(eq(url), eq(HttpMethod.GET), any(HttpEntity.class), eq(UserProfile.class)))
                .thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

        // Act
        UserProfile result = spotifyServiceMock.getUserProfile(accessToken);

        // Assert
        assertNotNull(result);
        // Add more assertions to validate the properties of UserProfile
    }

    // ====================== SpotifyController Tests ======================

    @Test
    public void testGetUserProfile_SpotifyController() throws Exception {
        // Arrange
        String accessToken = "testToken";
        UserProfile mockProfile = new UserProfile();
        when(spotifyService.getUserProfile(accessToken)).thenReturn(mockProfile);

        // Act & Assert
        mockMvc.perform(get("/spotify/user-profile").param("accessToken", accessToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockProfile.getId()));
        // Add more expectations based on the UserProfile structure
    }

    // ====================== SearchController Tests ======================

    @Test
    public void testSearchTracks_SearchController() throws Exception {
        // Arrange
        String query = "testQuery";
        String accessToken = "testToken";
        List<TrackDTO> mockSearchResults = List.of(
                new TrackDTO("trackId1", "Track Name 1", "Artist Name 1", "Album Name 1"),
                new TrackDTO("trackId2", "Track Name 2", "Artist Name 2", "Album Name 2")
        );
        doReturn(mockSearchResults).when(searchService).searchTracks(anyString(), anyString());


        // Act & Assert
        mockMvc.perform(get("/api/search").param("query", query).param("accessToken", accessToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(mockSearchResults.get(0).name()))
                .andExpect(jsonPath("$[1].name").value(mockSearchResults.get(1).name()));
        // Add more assertions as needed
    }


    // Additional tests for other functionalities can be added here
}
