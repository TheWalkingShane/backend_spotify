package com.cst438.controller;

public class UserProfile {
    private String id;
    private String username;
    private String access_token;
    private String refresh_token;
    private String displayName; // Add the displayName field
    private int expires_in;	// Milliseconds since computer time started.

    // Constructor
    public UserProfile() {
        // Default constructor
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

    public String getDisplayName() { // Getter for displayName
        return displayName;
    }

    public void setDisplayName(String displayName) { // Setter for displayName
        this.displayName = displayName;
    }

    
}

