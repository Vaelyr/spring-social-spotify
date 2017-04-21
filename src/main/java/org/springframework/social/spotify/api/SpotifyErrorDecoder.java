package org.springframework.social.spotify.api;

import java.io.IOException;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

public class SpotifyErrorDecoder implements ErrorDecoder {

	private Decoder decoder;
	private ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

	public SpotifyErrorDecoder(Decoder decoder) {
		this.decoder = decoder;
	}

	@Override
	public Exception decode(String methodKey, Response response) {
		try {
			return (Exception) decoder.decode(response, SpotifyClientError.class);
		} catch (IOException e) {
			return defaultDecoder.decode(methodKey, response);
		}
	}

}
