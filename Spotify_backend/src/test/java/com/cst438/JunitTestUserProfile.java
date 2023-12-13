package com.cst438;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.cst438.controller.UserProfileController;
import com.cst438.domain.UserProfile;
import com.cst438.domain.UserRepository;


@ExtendWith(MockitoExtension.class)
@WebMvcTest({UserProfileController.class})
public class JunitTestUserProfile {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @InjectMocks
    private UserProfileController userProfileController;
    /*
    @Test
    public void testGetUserProfile() throws Exception {
        String userId = "testUser";
        UserProfile mockUser = new UserProfile();
        mockUser.setUsername(userId);

        when(userRepository.findByUsername(anyString())).thenReturn(mockUser);

        mockMvc.perform(get("/profile")
                .param("user_id", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(userId));
    }

    @Test
    public void testCreateUserProfile() throws Exception {
        UserProfile mockUser = new UserProfile();
        mockUser.setUsername("newUser");

        when(userRepository.findByUsername(anyString())).thenReturn(null);
        when(userRepository.save(any(UserProfile.class))).thenReturn(mockUser);

        mockMvc.perform(post("/profile/new")
                .param("user_id", "newUser")
                .param("access_token", "access")
                .param("refresh_token", "refresh")
                .param("expires_in", "1000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("newUser"));
    }

    @Test
    public void testUpdateUserProfile() throws Exception {
        String userId = "existingUser";
        UserProfile existingUser = new UserProfile();
        existingUser.setUsername(userId);

        when(userRepository.findByUsername(anyString())).thenReturn(existingUser);
        when(userRepository.save(any(UserProfile.class))).thenReturn(existingUser);

        mockMvc.perform(put("/profile/refresh")
                .param("user_id", userId)
                .param("access_token", "newAccess")
                .param("refresh_token", "newRefresh")
                .param("expires_in", "2000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(userId));
    }

    @Test
    public void testDeleteUserProfile() throws Exception {
        String userId = "deleteUser";
        UserProfile deleteUser = new UserProfile();
        deleteUser.setUsername(userId);

        when(userRepository.findByUsername(anyString())).thenReturn(deleteUser).thenReturn(null);

        mockMvc.perform(delete("/profile/remove")
                .param("user_id", userId)
                .param("access_token", "access")
                .param("refresh_token", "refresh")
                .param("expires_in", "1000"))
                .andExpect(status().isOk());
    }
    */
}
