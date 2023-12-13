package com.cst438.domain;

public record UserProfileDTO (String username, String access_token, String refresh_token, int expires_in){

}
