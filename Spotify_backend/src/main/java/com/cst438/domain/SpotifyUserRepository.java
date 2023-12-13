package com.cst438.domain;

import org.springframework.data.repository.CrudRepository;

public interface SpotifyUserRepository extends CrudRepository<SpotifyUser, Integer>{
	SpotifyUser getAccessTokenByRefreshToken(String refresh_token);
	SpotifyUser getRefreshTokenByAccessToken(String access_token);
}
