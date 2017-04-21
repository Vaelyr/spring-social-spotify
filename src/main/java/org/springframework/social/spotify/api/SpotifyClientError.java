package org.springframework.social.spotify.api;

import lombok.Getter;

public class SpotifyClientError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2169745172295858001L;
	@Getter
	private String message;
}
