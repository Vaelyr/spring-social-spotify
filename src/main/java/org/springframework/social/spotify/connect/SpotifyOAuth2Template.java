package org.springframework.social.spotify.connect;

import org.springframework.social.oauth2.OAuth2Template;

public class SpotifyOAuth2Template extends OAuth2Template {

	private static final String AUTHORIZE_URL = "https://accounts.spotify.com/authorize";
	private static final String ACCESS_TOKEN_URL = "https://accounts.spotify.com/authorize";

	public SpotifyOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, AUTHORIZE_URL, ACCESS_TOKEN_URL);
	}

}
