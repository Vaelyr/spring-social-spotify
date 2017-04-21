package org.springframework.social.spotify.api.operations;

import org.springframework.social.spotify.api.AlbumSimplified;
import org.springframework.social.spotify.api.AlbumType;
import org.springframework.social.spotify.api.ArrayToStringExpander;
import org.springframework.social.spotify.api.Artist;
import org.springframework.social.spotify.api.Artists;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.Tracks;

import feign.Param;
import feign.RequestLine;

/**
 * Endpoints for retrieving information about one or more artists from the
 * Spotify catalog.
 * 
 * @author paulosigrist
 *
 */
public interface ArtistsOperations {

	/**
	 * Get Spotify catalog information for a single artist identified by their
	 * unique Spotify ID.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @return {@link Artist}
	 */
	@RequestLine("GET /v1/artists/{id}")
	Artist getArtist(@Param("id") String artistId);

	/**
	 * Get Spotify catalog information for several artists based on their
	 * Spotify IDs.
	 * 
	 * @param artistsIds
	 *            A list of the Spotify IDs for the artists. Maximum: 50 IDs.
	 * @return {@link Artists}
	 */
	@RequestLine("GET /v1/artists/?ids={ids}")
	Artists getSeveralArtists(@Param(value = "ids", expander = ArrayToStringExpander.class) String... artistsIds);

	/**
	 * Get Spotify catalog information about an artist’s albums.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/artists/{id}/albums")
	Paging<AlbumSimplified> getArtistAlbums(@Param("id") String artistId);

	/**
	 * Get Spotify catalog information about an artist’s albums.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @param albumType
	 *            A list of keywords that will be used to filter the response.
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/artists/{id}/albums?album_type={albumType}")
	Paging<AlbumSimplified> getArtistAlbums(@Param("id") String artistId,
			@Param(value = "albumType", expander = ArrayToStringExpander.class) AlbumType... albumType);

	/**
	 * Get Spotify catalog information about an artist’s albums.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @param market
	 *            An
	 *            <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>. Provide this parameter if you
	 *            want to apply <a href=
	 *            "https://developer.spotify.com/web-api/track-relinking-guide/">Track
	 *            Relinking</a>
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/artists/{id}/albums?market={market}")
	Paging<AlbumSimplified> getArtistAlbums(@Param("id") String artistId, @Param("market") String market);

	/**
	 * Get Spotify catalog information about an artist’s albums.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @param market
	 *            An
	 *            <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>. Provide this parameter if you
	 *            want to apply <a href=
	 *            "https://developer.spotify.com/web-api/track-relinking-guide/">Track
	 *            Relinking</a>
	 * @param albumType
	 *            A list of keywords that will be used to filter the response.
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/artists/{id}/albums?market={market}&album_type={albumType}")
	Paging<AlbumSimplified> getArtistAlbums(@Param("id") String artistId, @Param("market") String market,
			@Param(value = "albumType", expander = ArrayToStringExpander.class) AlbumType... albumType);

	/**
	 * Get Spotify catalog information about an artist’s albums.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @param limit
	 *            The number of album objects to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first album to return. Default: 0 (i.e., the
	 *            first album). Use with limit to get the next set of albums.
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/artists/{id}/albums?limit={limit}&offset={offset}")
	Paging<AlbumSimplified> getArtistAlbums(@Param("id") String artistId, @Param("limit") Integer limit,
			@Param("offset") Integer offset);

	/**
	 * Get Spotify catalog information about an artist’s albums.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @param limit
	 *            The number of album objects to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first album to return. Default: 0 (i.e., the
	 *            first album). Use with limit to get the next set of albums.
	 * @param albumType
	 *            A list of keywords that will be used to filter the response.
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/artists/{id}/albums?limit={limit}&offset={offset}&album_type={albumType}")
	Paging<AlbumSimplified> getArtistAlbums(@Param("id") String artistId, @Param("limit") Integer limit,
			@Param("offset") Integer offset,
			@Param(value = "albumType", expander = ArrayToStringExpander.class) AlbumType... albumType);

	/**
	 * Get Spotify catalog information about an artist’s albums.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @param limit
	 *            The number of album objects to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first album to return. Default: 0 (i.e., the
	 *            first album). Use with limit to get the next set of albums.
	 * @param market
	 *            An
	 *            <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>. Provide this parameter if you
	 *            want to apply <a href=
	 *            "https://developer.spotify.com/web-api/track-relinking-guide/">Track
	 *            Relinking</a>
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/artists/{id}/albums?limit={limit}&offset={offset}&market={market}")
	Paging<AlbumSimplified> getArtistAlbums(@Param("id") String artistId, @Param("limit") Integer limit,
			@Param("offset") Integer offset, @Param("market") String market);

	/**
	 * Get Spotify catalog information about an artist’s albums.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @param limit
	 *            The number of album objects to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first album to return. Default: 0 (i.e., the
	 *            first album). Use with limit to get the next set of albums.
	 * @param market
	 *            An
	 *            <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>. Provide this parameter if you
	 *            want to apply <a href=
	 *            "https://developer.spotify.com/web-api/track-relinking-guide/">Track
	 *            Relinking</a>
	 * @param albumType
	 *            A list of keywords that will be used to filter the response.
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/artists/{id}/albums?limit={limit}&offset={offset}&market={market}&album_type={albumType}")
	Paging<AlbumSimplified> getArtistAlbums(@Param("id") String artistId, @Param("limit") Integer limit,
			@Param("offset") Integer offset, @Param("market") String market,
			@Param(value = "albumType", expander = ArrayToStringExpander.class) AlbumType... albumType);

	/**
	 * Get Spotify catalog information about an artist’s top tracks by country.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @param country
	 *            The country: an
	 *            <ahref="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO
	 *            3166-1 alpha-2 country code</a>.
	 * @return {@link Tracks}
	 */
	@RequestLine("GET /v1/artists/{id}/top-tracks?country={country}")
	Tracks getTopTracks(@Param("id") String artistId, @Param("country") String country);

	/**
	 * Get Spotify catalog information about artists similar to a given artist.
	 * Similarity is based on analysis of the Spotify community’s listening
	 * history.
	 * 
	 * @param artistId
	 *            The Spotify ID for the artist.
	 * @return {@link Artists}
	 */
	@RequestLine("GET /v1/artists/{id}/related-artists")
	Artists getRelatedArtists(@Param("id") String artistId);

}
