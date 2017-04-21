package org.springframework.social.spotify.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.spotify.api.Spotify;
import org.springframework.social.spotify.api.impl.SpotifyTemplate;

public class SpotifyServiceProvider extends AbstractOAuth2ServiceProvider<Spotify> {

	private String clientId;

	public SpotifyServiceProvider(String clientId, String clientSecret) {
		super(new SpotifyOAuth2Template(clientId, clientSecret));
		this.clientId = clientId;
	}

	@Override
	public Spotify getApi(String accessToken) {
		return new SpotifyTemplate(clientId, accessToken);
	}

}
