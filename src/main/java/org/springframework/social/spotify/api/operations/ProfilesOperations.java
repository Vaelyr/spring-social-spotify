package org.springframework.social.spotify.api.operations;

import org.springframework.social.spotify.api.UserPrivate;
import org.springframework.social.spotify.api.UserPublic;

import feign.Param;
import feign.RequestLine;

public interface ProfilesOperations {

	@RequestLine("GET /v1/me")
	UserPrivate me();

	@RequestLine("GET /v1/users/{id}")
	UserPublic getUser(@Param("id") String userId);
}
