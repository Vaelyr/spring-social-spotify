
package org.springframework.social.spotify.api.operations;

import org.springframework.social.spotify.api.ArrayToStringExpander;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.SavedAlbum;
import org.springframework.social.spotify.api.SavedTrack;

import feign.Param;
import feign.RequestLine;

/**
 * Endpoints for retrieving information about, and managing, tracks that the
 * current user has saved in their “Your Music” library.
 * 
 * @author paulosigrist
 *
 */
public interface LibraryOperations {

	/**
	 * Save one or more tracks to the current user’s “Your Music” library.
	 * 
	 * @param tracksIds
	 *            A list of the Spotify IDs.
	 */
	@RequestLine("PUT /v1/me/tracks?ids={ids}")
	void saveTracks(@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracksIds);

	/**
	 * Get a list of the songs saved in the current Spotify user’s “Your Music”
	 * library.
	 * 
	 * @return {@link Paging<SavedTrack>}
	 */
	@RequestLine("GET /v1/me/tracks")
	Paging<SavedTrack> getSavedTracks();

	/**
	 * Get a list of the songs saved in the current Spotify user’s “Your Music”
	 * library.
	 * 
	 * @param market
	 *            An ISO 3166-1 alpha-2 country code. Provide this parameter if
	 *            you want to apply Track Relinking.
	 * 
	 * @return {@link Paging<SavedTrack>}
	 */
	@RequestLine("GET /v1/me/tracks?market={market}")
	Paging<SavedTrack> getSavedTracks(@Param("market") String market);

	/**
	 * Get a list of the songs saved in the current Spotify user’s “Your Music”
	 * library.
	 * 
	 * @param limit
	 *            The maximum number of objects to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first object to return. Default: 0 (i.e., the
	 *            first object). Use with limit to get the next set of objects.
	 * 
	 * @return {@link Paging<SavedTrack>}
	 */
	@RequestLine("GET /v1/me/tracks?limit={limit}&offset={offset}")
	Paging<SavedTrack> getSavedTracks(@Param("limit") Integer limit, @Param("offset") Integer offset);

	/**
	 * Get a list of the songs saved in the current Spotify user’s “Your Music”
	 * library.
	 * 
	 * @param limit
	 *            The maximum number of objects to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first object to return. Default: 0 (i.e., the
	 *            first object). Use with limit to get the next set of objects.
	 * @param market
	 *            An ISO 3166-1 alpha-2 country code. Provide this parameter if
	 *            you want to apply Track Relinking.
	 *
	 * @return {@link Paging<SavedTrack>}
	 */
	@RequestLine("GET /v1/me/tracks?limit={limit}&offset={offset}&market={market}")
	Paging<SavedTrack> getSavedTracks(@Param("limit") Integer limit, @Param("offset") Integer offset,
			@Param("market") String market);

	/**
	 * Remove one or more tracks from the current user’s “Your Music” library.
	 * 
	 * @param tracksIds
	 *            A comma-separated list of the Spotify IDs.
	 */
	@RequestLine("DELETE /v1/me/tracks?ids={ids}")
	void removeSavedTracks(@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracksIds);

	/**
	 * Check if one or more tracks is already saved in the current Spotify
	 * user’s “Your Music” library.
	 * 
	 * @param tracksIds
	 *            A list of the Spotify IDs for the tracks. Maximum: 50 IDs.
	 * @return an array of Boolean for each track
	 */
	@RequestLine("GET /v1/me/tracks/contains?ids={ids}")
	Boolean[] isSavedTracks(@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracksIds);

	/**
	 * Save one or more albums to the current user’s “Your Music” library.
	 * 
	 * @param albumsIds
	 *            A list of the Spotify IDs.
	 */
	@RequestLine("PUT /v1/me/albums?ids={ids}")
	void saveAlbums(@Param(value = "ids", expander = ArrayToStringExpander.class) String... albumsIds);

	/**
	 * Get a list of the albums saved in the current Spotify user’s “Your Music”
	 * library.
	 * 
	 * @return {@link Paging<SavedAlbum>}
	 */
	@RequestLine("GET /v1/me/albums")
	Paging<SavedAlbum> getSavedAlbums();

	/**
	 * Get a list of the albums saved in the current Spotify user’s “Your Music”
	 * library.
	 * 
	 * @param market
	 *            An ISO 3166-1 alpha-2 country code. Provide this parameter if
	 *            you want to apply Track Relinking.
	 * 
	 * @return {@link Paging<SavedAlbum>}
	 */
	@RequestLine("GET /v1/me/albums?market={market}")
	Paging<SavedAlbum> getSavedAlbums(@Param("market") String market);

	/**
	 * Get a list of the albums saved in the current Spotify user’s “Your Music”
	 * library.
	 * 
	 * @param limit
	 *            The maximum number of objects to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first object to return. Default: 0 (i.e., the
	 *            first object). Use with limit to get the next set of objects.
	 * @return {@link Paging<SavedAlbum>}
	 */
	@RequestLine("GET /v1/me/albums?limit={limit}&offset={offset}")
	Paging<SavedAlbum> getSavedAlbums(@Param("limit") Integer limit, @Param("offset") Integer offset);

	/**
	 * Get a list of the albums saved in the current Spotify user’s “Your Music”
	 * library.
	 * 
	 * @param limit
	 *            The maximum number of objects to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first object to return. Default: 0 (i.e., the
	 *            first object). Use with limit to get the next set of objects.
	 * @param market
	 *            An ISO 3166-1 alpha-2 country code. Provide this parameter if
	 *            you want to apply Track Relinking.
	 * @return {@link Paging<SavedAlbum>}
	 */
	@RequestLine("GET /v1/me/albums?limit={limit}&offset={offset}&market={market}")
	Paging<SavedAlbum> getSavedAlbums(@Param("limit") Integer limit, @Param("offset") Integer offset,
			@Param("market") String market);

	/**
	 * Remove one or more albums from the current user’s “Your Music” library.
	 * 
	 * @param albumsIds
	 *            A list of the Spotify IDs.
	 */
	@RequestLine("DELETE /v1/me/albums?ids={ids}")
	void removeSavedAlbums(@Param(value = "ids", expander = ArrayToStringExpander.class) String... albumsIds);

	/**
	 * A list of the Spotify IDs.
	 * 
	 * @param albumsIds
	 *            A list of the Spotify IDs.
	 * 
	 * @return an array of Boolean for each album.
	 */
	@RequestLine("GET /v1/me/albums/contains?ids={ids}")
	Boolean[] isSavedAlbums(@Param(value = "ids", expander = ArrayToStringExpander.class) String... albumsIds);
}
