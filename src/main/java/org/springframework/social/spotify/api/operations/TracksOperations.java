package org.springframework.social.spotify.api.operations;

import org.springframework.social.spotify.api.ArrayToStringExpander;
import org.springframework.social.spotify.api.Track;
import org.springframework.social.spotify.api.Tracks;

import feign.Param;
import feign.RequestLine;

public interface TracksOperations {

	@RequestLine("GET /v1/tracks/{id}")
	Track getTrack(@Param("id") String trackId);

	@RequestLine("GET /v1/tracks/{id}?market={market}")
	Track getTrack(@Param("id") String trackId, @Param("market") String market);

	@RequestLine("GET /v1/tracks/?ids={ids}")
	Tracks getTracks(@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracks);

	@RequestLine("GET /v1/tracks/?ids={ids}&market={market}")
	Tracks getTracks(@Param("market") String market,
			@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracks);

	// TODO Audio Features/ Analysis
}
