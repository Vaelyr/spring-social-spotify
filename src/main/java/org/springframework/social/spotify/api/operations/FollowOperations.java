package org.springframework.social.spotify.api.operations;

import org.springframework.social.spotify.api.ArrayToStringExpander;
import org.springframework.social.spotify.api.Artist;
import org.springframework.social.spotify.api.CursorPaging;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * These endpoints allow you manage the artists, users and playlists that a
 * Spotify user follows.
 * 
 * @author paulosigrist
 *
 */
public interface FollowOperations {

	/**
	 * Get the current user’s followed artists.
	 * 
	 * @return {@link CursorPaging<Artist>}
	 */
	@RequestLine("GET /v1/me/following?type=artist")
	CursorPaging<Artist> followingArtists();

	/**
	 * Get the current user’s followed artists.
	 * 
	 * @param limit
	 *            The maximum number of items to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param after
	 *            The last artist ID retrieved from the previous request.
	 * @return {@link CursorPaging<Artist>}
	 */
	@RequestLine("GET /v1/me/following?type=artist&limit={limit}&after={after}")
	CursorPaging<Artist> followingArtists(@Param("limit") Integer limit, @Param("after") String after);

	/**
	 * Add the current user as a follower of one or more artists.
	 * 
	 * @param artistIds
	 *            A list of the artist IDs
	 */
	@RequestLine("PUT /v1/me/following?type=artist&ids={ids}")
	void followArtist(@Param(value = "ids", expander = ArrayToStringExpander.class) String... artistIds);

	/**
	 * Remove the current user as a follower of one or more artists.
	 * 
	 * @param artistIds
	 *            A list of the artist IDs
	 */
	@RequestLine("DELETE /v1/me/following?type=artist&ids={ids}")
	void unfollowArtist(@Param(value = "ids", expander = ArrayToStringExpander.class) String... artistIds);

	/**
	 * Check to see if the current user is following one or more artists.
	 * 
	 * @param artistIds
	 *            A list of the artist IDs
	 * @return an array of Boolean for each artist
	 */
	@RequestLine("GET /v1/me/following/contains?type=artist&ids={ids}")
	Boolean[] isFollowingArtist(@Param(value = "ids", expander = ArrayToStringExpander.class) String... artistIds);

	/**
	 * Add the current user as a follower of one or more users.
	 * 
	 * @param usersIds
	 *            A list of the users IDs
	 */
	@RequestLine("PUT /v1/me/following?type=user&ids={ids}")
	void followUser(@Param(value = "ids", expander = ArrayToStringExpander.class) String... userIds);

	/**
	 * Remove the current user as a follower of one or more users.
	 * 
	 * @param usersIds
	 *            A list of the users IDs
	 */
	@RequestLine("DELETE /v1/me/following?type=user&ids={ids}")
	void unfollowUser(@Param(value = "ids", expander = ArrayToStringExpander.class) String... userIds);

	/**
	 * Check to see if the current user is following one or more users.
	 * 
	 * @param usersIds
	 *            A list of the users IDs
	 * @return an array of Boolean for each user
	 */
	@RequestLine("GET /v1/me/following/contains?type=user&ids={ids}")
	Boolean[] isFollowingUser(@Param(value = "ids", expander = ArrayToStringExpander.class) String... userIds);

	/**
	 * Add the current user as a follower of a playlist.
	 * 
	 * @param ownerId
	 *            The Spotify user ID of the person who owns the playlist.
	 * @param playlistId
	 *            The Spotify ID of the playlist. Any playlist can be followed,
	 *            regardless of its public/private status, as long as you know
	 *            its playlist ID.
	 * @param publicFollowing
	 *            If true the playlist will be included in user's public
	 *            playlists, if false it will remain private. To be able to
	 *            follow playlists privately, the user must have granted the
	 *            playlist-modify-private
	 */
	@RequestLine("PUT /v1/users/{owner_id}/playlists/{playlist_id}/followers")
	@Headers("Content-Type: application/json")
	@Body("%7B\"public\": {publicFollowing} %7D")
	void followPlaylist(@Param("owner_id") String ownerId, @Param("playlist_id") String playlistId,
			@Param("publicFollowing") Boolean publicFollowing);

	/**
	 * Remove the current user as a follower of a playlist.
	 * 
	 * @param ownerId
	 *            The Spotify user ID of the person who owns the playlist.
	 * @param playlistId
	 *            The Spotify ID of the playlist that is to be no longer
	 *            followed.
	 */
	@RequestLine("DELETE /v1/users/{owner_id}/playlists/{playlist_id}/followers")
	void unfollowPlaylist(@Param("owner_id") String ownerId, @Param("playlist_id") String playlistId);

	/**
	 * Check to see if one or more Spotify users are following a specified
	 * playlist.
	 * 
	 * @param ownerId
	 *            The Spotify user ID of the person who owns the playlist.
	 * @param playlistId
	 *            The Spotify ID of the playlist.
	 * @param userIds
	 *            A list of Spotify User IDs; the ids of the users that you want
	 *            to check to see if they follow the playlist. Maximum: 5 ids.
	 * @return an array of Boolean for each user
	 */
	@RequestLine("GET /v1/users/{owner_id}/playlists/{playlist_id}/followers/contains?ids={ids}")
	Boolean[] isFollowingPlaylist(@Param("owner_id") String ownerId, @Param("playlist_id") String playlistId,
			@Param(value = "ids", expander = ArrayToStringExpander.class) String... userIds);
}
