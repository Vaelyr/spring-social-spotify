package org.springframework.social.spotify.api;

import org.springframework.social.ApiBinding;
import org.springframework.social.spotify.api.operations.AlbumsOperations;
import org.springframework.social.spotify.api.operations.PersonalizationOperations;
import org.springframework.social.spotify.api.operations.ProfilesOperations;

public interface Spotify extends ApiBinding {

	ProfilesOperations profilesOperations();
	
	AlbumsOperations albumOperations();

	PersonalizationOperations personalizationOperations();
}
