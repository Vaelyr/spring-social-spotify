package org.springframework.social.spotify.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.spotify.api.Spotify;

public class SpotifyConnectionFactory extends OAuth2ConnectionFactory<Spotify>{

	public SpotifyConnectionFactory(String clientId, String clientSecret) {
		super("spotify", new SpotifyServiceProvider(clientId, clientSecret), new SpotifyAdapter());
	}

}
