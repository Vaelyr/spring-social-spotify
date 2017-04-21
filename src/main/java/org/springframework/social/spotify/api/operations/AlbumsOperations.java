package org.springframework.social.spotify.api.operations;

import org.springframework.social.spotify.api.Album;
import org.springframework.social.spotify.api.Albums;
import org.springframework.social.spotify.api.ArrayToStringExpander;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.TrackSimplified;

import feign.Param;
import feign.RequestLine;

/**
 * Endpoints for retrieving information about one or more albums from the
 * Spotify catalog.
 * 
 * @author paulosigrist
 *
 */
public interface AlbumsOperations {
	/**
	 * Get Spotify catalog information for a single album
	 * 
	 * @param id
	 *            The Spotify ID for the album
	 * @return {@link Album}
	 */
	@RequestLine("GET /v1/albums/{id}")
	Album getAlbum(@Param("id") String id);

	/**
	 * Get Spotify catalog information for a single album
	 * 
	 * @param id
	 *            The Spotify ID for the album
	 * @param market
	 *            An
	 *            <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>. Provide this parameter if you
	 *            want to apply <a href=
	 *            "https://developer.spotify.com/web-api/track-relinking-guide/">Track
	 *            Relinking</a>
	 * @return {@link Album}
	 */
	@RequestLine("GET /v1/albums/{id}?market={market}")
	Album getAlbum(@Param("id") String albumId, @Param("market") String market);

	/**
	 * Get Spotify catalog information for multiple albums identified by their
	 * Spotify IDs.
	 * 
	 * @param albunsIds
	 *            A comma-separated list of the Spotify IDs for the albums.
	 *            Maximum: 20 IDs.
	 * @return {@link Albums}
	 */
	@RequestLine("GET /v1/albums/?ids={ids}")
	Albums getSeveralAlbums(@Param(value = "ids", expander = ArrayToStringExpander.class) String... albunsIds);

	/**
	 * Get Spotify catalog information for multiple albums identified by their
	 * Spotify IDs.
	 * 
	 * @param market
	 *            An
	 *            <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>. Provide this parameter if you
	 *            want to apply <a href=
	 *            "https://developer.spotify.com/web-api/track-relinking-guide/">Track
	 *            Relinking</a>
	 * @param albunsIds
	 *            A comma-separated list of the Spotify IDs for the albums.
	 *            Maximum: 20 IDs.
	 * @return {@link Albums}
	 */
	@RequestLine("GET /v1/albums/?ids={ids}&market={market}")
	Albums getSeveralAlbumsMarket(@Param("market") String market,
			@Param(value = "ids", expander = ArrayToStringExpander.class) String... albunsIds);

	/**
	 * Get Spotify catalog information about an album’s tracks. Optional
	 * parameters can be used to limit the number of tracks returned.
	 * 
	 * @param albumId
	 *            The Spotify ID for the album.
	 * @return {@link Paging<TrackSimplified>}
	 */
	@RequestLine("GET /v1/albums/{id}/tracks")
	Paging<TrackSimplified> getAlbumTracks(@Param("id") String albumId);

	/**
	 * Get Spotify catalog information about an album’s tracks. Optional
	 * parameters can be used to limit the number of tracks returned.
	 * 
	 * @param albumId
	 *            The Spotify ID for the album.
	 * @param market
	 *            An
	 *            <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>. Provide this parameter if you
	 *            want to apply <a href=
	 *            "https://developer.spotify.com/web-api/track-relinking-guide/">Track
	 *            Relinking</a>
	 * @return {@link Paging<TrackSimplified>}
	 */
	@RequestLine("GET /v1/albums/{id}/tracks?market={market}")
	Paging<TrackSimplified> getAlbumTracks(@Param("id") String albumId, @Param("market") String market);

	/**
	 * Get Spotify catalog information about an album’s tracks. Optional
	 * parameters can be used to limit the number of tracks returned.
	 * 
	 * @param albumId
	 *            The Spotify ID for the album.
	 * @param limit
	 *            The maximum number of tracks to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first track to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of tracks.
	 * @return {@link Paging<TrackSimplified>}
	 */
	@RequestLine("GET /v1/albums/{id}/tracks?limit={limit}&offset={offset}")
	Paging<TrackSimplified> getAlbumTracks(@Param("id") String albumId, @Param("limit") Integer limit,
			@Param("offset") Integer offset);

	/**
	 * Get Spotify catalog information about an album’s tracks. Optional
	 * parameters can be used to limit the number of tracks returned.
	 * 
	 * @param albumId
	 *            The Spotify ID for the album.
	 * @param limit
	 *            The maximum number of tracks to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first track to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of tracks.
	 * @param market
	 *            An
	 *            <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>. Provide this parameter if you
	 *            want to apply <a href=
	 *            "https://developer.spotify.com/web-api/track-relinking-guide/">Track
	 *            Relinking</a>
	 * @return {@link Paging<TrackSimplified>}
	 */
	@RequestLine("GET /v1/albums/{id}/tracks?limit={limit}&offset={offset}&market={market}")
	Paging<TrackSimplified> getAlbumTracks(@Param("id") String albumId, @Param("limit") Integer limit,
			@Param("offset") Integer offset, @Param("market") String market);

}
