package org.springframework.social.spotify.api.operations;

import org.springframework.social.spotify.api.Artist;
import org.springframework.social.spotify.api.CursorPaging;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.PlayHistory;
import org.springframework.social.spotify.api.TimeRange;
import org.springframework.social.spotify.api.Track;

import feign.Param;
import feign.RequestLine;

// TODO
public interface PersonalizationOperations {

	@RequestLine("GET /v1/me/top/artists")
	Paging<Artist> topArtists();

	@RequestLine("GET /v1/me/top/artists?time_range={time_range}")
	Paging<Artist> topArtists(@Param("time_range") TimeRange timeRange);

	@RequestLine("GET /v1/me/top/artists?limit={limit}&offset={offset}")
	Paging<Artist> topArtists(@Param("limit") Integer limit, @Param("offset") Integer offset);

	@RequestLine("GET /v1/me/top/artists?time_range={time_range}&limit={limit}&offset={offset}")
	Paging<Artist> topArtists(@Param("time_range") TimeRange timeRange, @Param("limit") Integer limit,
			@Param("offset") Integer offset);

	@RequestLine("GET /v1/me/top/tracks")
	Paging<Track> topTracks();

	@RequestLine("GET /v1/me/top/tracks?time_range={time_range}")
	Paging<Track> topTracks(@Param("time_range") TimeRange timeRange);

	@RequestLine("GET /v1/me/top/tracks?limit={limit}&offset={offset}")
	Paging<Track> topTracks(@Param("limit") Integer limit, @Param("offset") Integer offset);

	@RequestLine("GET /v1/me/top/tracks?time_range={time_range}&limit={limit}&offset={offset}")
	Paging<Track> topTracks(@Param("time_range") TimeRange timeRange, @Param("limit") Integer limit,
			@Param("offset") Integer offset);

	// FIXME user-read-recently-played
	@RequestLine("GET /v1/me/player/recently-played")
	CursorPaging<PlayHistory> recentPlayed();
}
