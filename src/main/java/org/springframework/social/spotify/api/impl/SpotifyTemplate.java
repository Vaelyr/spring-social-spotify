package org.springframework.social.spotify.api.impl;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.spotify.api.Spotify;
import org.springframework.social.spotify.api.SpotifyErrorDecoder;
import org.springframework.social.spotify.api.operations.AlbumsOperations;
import org.springframework.social.spotify.api.operations.PersonalizationOperations;
import org.springframework.social.spotify.api.operations.ProfilesOperations;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Getter;

public class SpotifyTemplate extends AbstractOAuth2ApiBinding implements Spotify {
	public static final String BASE_URL = "https://api.spotify.com";

	@Getter
	private String clientId;
	@Getter
	private String accessToken;

	private ProfilesOperations userOperations;

	private AlbumsOperations albumOperations;

	private PersonalizationOperations personalizationOperations;

	public SpotifyTemplate(String clientId, String accessToken) {
		super(accessToken);
		this.clientId = clientId;
		this.accessToken = accessToken;

		RequestInterceptor interceptor = new AuthRequestInterceptor(accessToken);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Decoder decoder = new JacksonDecoder(mapper);
		Encoder encoder = new JacksonEncoder(mapper);

		ErrorDecoder errorDecoder = new SpotifyErrorDecoder(decoder);

		userOperations = Feign.builder().errorDecoder(errorDecoder).decoder(decoder).encoder(encoder).requestInterceptor(interceptor)
				.target(ProfilesOperations.class, BASE_URL);

		albumOperations = Feign.builder().errorDecoder(errorDecoder)
				.logger(new Logger.JavaLogger().appendToFile("albumOperations.log")).logLevel(Logger.Level.FULL)
				.decoder(decoder).encoder(encoder).requestInterceptor(interceptor).target(AlbumsOperations.class, BASE_URL);

		personalizationOperations = Feign.builder().errorDecoder(errorDecoder)
				.logger(new Logger.JavaLogger().appendToFile("albumOperations.log")).logLevel(Logger.Level.FULL)
				.decoder(decoder).encoder(encoder).requestInterceptor(interceptor).target(PersonalizationOperations.class, BASE_URL);

	}

	@Override
	public ProfilesOperations profilesOperations() {
		return userOperations;
	}

	@Override
	public AlbumsOperations albumOperations() {
		return albumOperations;
	}

	@Override
	public PersonalizationOperations personalizationOperations() {
		return personalizationOperations;
	}

}
