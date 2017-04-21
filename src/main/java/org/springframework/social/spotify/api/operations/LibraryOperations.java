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

	@RequestLine("PUT /v1/me/tracks?ids={ids}")
	void saveTracks(@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracksIds);

	@RequestLine("GET /v1/me/tracks")
	Paging<SavedTrack> getSavedTracks();

	@RequestLine("GET /v1/me/tracks?market={market}")
	Paging<SavedTrack> getSavedTracks(@Param("market") String market);

	@RequestLine("GET /v1/me/tracks?limit={limit}&offset={offset}")
	Paging<SavedTrack> getSavedTracks(@Param("limit") Integer limit, @Param("offset") Integer offset);

	@RequestLine("GET /v1/me/tracks?limit={limit}&offset={offset}&market={market}")
	Paging<SavedTrack> getSavedTracks(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("market") String market);

	@RequestLine("DELETE /v1/me/tracks?ids={ids}")
	void removeSavedTracks(@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracksIds);

	@RequestLine("GET /v1/me/tracks/contains/?ids={ids}")
	Boolean[] isSavedTracks(@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracksIds);

	
	@RequestLine("PUT /v1/me/albums?ids={ids}")
	void saveAlbums(@Param(value = "ids", expander = ArrayToStringExpander.class) String... tracksIds);

	@RequestLine("GET /v1/me/albums")
	Paging<SavedAlbum> getSavedAlbums();

	@RequestLine("GET /v1/me/albums?market={market}")
	Paging<SavedAlbum> getSavedAlbums(@Param("market") String market);

	@RequestLine("GET /v1/me/albums?limit={limit}&offset={offset}")
	Paging<SavedAlbum> getSavedAlbums(@Param("limit") Integer limit, @Param("offset") Integer offset);

	@RequestLine("GET /v1/me/albums?limit={limit}&offset={offset}&market={market}")
	Paging<SavedAlbum> getSavedAlbums(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("market") String market);

	@RequestLine("DELETE /v1/me/albums?ids={ids}")
	void removeSavedAlbums(@Param(value = "ids", expander = ArrayToStringExpander.class) String... albumsIds);

	@RequestLine("GET /v1/me/albums/contains/?ids={ids}")
	Boolean[] isSavedAlbums(@Param(value = "ids", expander = ArrayToStringExpander.class) String... albumsIds);
}
