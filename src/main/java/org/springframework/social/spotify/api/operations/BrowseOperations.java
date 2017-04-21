package org.springframework.social.spotify.api.operations;

import org.springframework.social.spotify.api.AlbumSimplified;
import org.springframework.social.spotify.api.Categories;
import org.springframework.social.spotify.api.Category;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.Playlists;

import feign.Param;
import feign.RequestLine;

/**
 * Endpoints for getting playlists and new album releases featured on Spotify’s
 * Browse tab.
 * 
 * @author paulosigrist
 *
 */
public interface BrowseOperations {

	/**
	 * Get a list of Spotify featured playlists (shown, for example, on a
	 * Spotify player’s “Browse” tab).
	 * 
	 * @return {@link Playlists}
	 */
	@RequestLine("GET /v1/browse/featured-playlists")
	Playlists featuredPlaylists();

	/**
	 * Get a list of Spotify featured playlists (shown, for example, on a
	 * Spotify player’s “Browse” tab).
	 * 
	 * @param limit
	 *            The maximum number of items to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first item to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of items.
	 * @return {@link Playlists}
	 */
	@RequestLine("GET /v1/browse/featured-playlists?limit={limit}&offset={offset}")
	Playlists featuredPlaylists(@Param("limit") Integer limit, @Param("offset") Integer offset);

	/**
	 * Get a list of Spotify featured playlists (shown, for example, on a
	 * Spotify player’s “Browse” tab).
	 * 
	 * @param locale
	 *            The desired language, consisting of a lowercase ISO 639
	 *            language code and an uppercase ISO 3166-1 alpha-2 country
	 *            code, joined by an underscore. For example: es_MX, meaning
	 *            "Spanish (Mexico)". Provide this parameter if you want the
	 *            results returned in a particular language (where available).
	 * 
	 * @param country
	 *            A country: an ISO 3166-1 alpha-2 country code. Provide this
	 *            parameter if you want the list of returned items to be
	 *            relevant to a particular country. If omitted, the returned
	 *            items will be relevant to all countries.
	 * @return {@link Playlists}
	 */
	@RequestLine("GET /v1/browse/featured-playlists?locale={locale}&country={country}")
	Playlists featuredPlaylists(@Param("locale") String locale, @Param("country") String country);

	/**
	 * Get a list of new album releases featured in Spotify (shown, for example,
	 * on a Spotify player’s “Browse” tab).
	 * 
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/browse/new-releases")
	Paging<AlbumSimplified> newReleases();

	/**
	 * Get a list of new album releases featured in Spotify (shown, for example,
	 * on a Spotify player’s “Browse” tab).
	 * 
	 * @param country
	 *            A country: an ISO 3166-1 alpha-2 country code. Provide this
	 *            parameter if you want the list of returned items to be
	 *            relevant to a particular country. If omitted, the returned
	 *            items will be relevant to all countries.
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/browse/new-releases?country={country}")
	Paging<AlbumSimplified> newReleases(@Param("country") String country);

	/**
	 * Get a list of new album releases featured in Spotify (shown, for example,
	 * on a Spotify player’s “Browse” tab).
	 * 
	 * @param limit
	 *            The maximum number of items to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first item to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of items.
	 * @return {@link Paging<AlbumSimplified>}
	 * 
	 */
	@RequestLine("GET /v1/browse/new-releases?limit={limit}&offset={offset}")
	Paging<AlbumSimplified> newReleases(@Param("limit") Integer limit, @Param("offset") Integer offset);

	/**
	 * Get a list of new album releases featured in Spotify (shown, for example,
	 * on a Spotify player’s “Browse” tab).
	 * 
	 * @param country
	 *            A country: an ISO 3166-1 alpha-2 country code. Provide this
	 *            parameter if you want the list of returned items to be
	 *            relevant to a particular country. If omitted, the returned
	 *            items will be relevant to all countries.
	 * @param limit
	 *            The maximum number of items to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first item to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of items.
	 * @return {@link Paging<AlbumSimplified>}
	 */
	@RequestLine("GET /v1/browse/new-releases?country={country}&limit={limit}&offset={offset}")
	Paging<AlbumSimplified> newReleases(@Param("country") String country, @Param("limit") Integer limit,
			@Param("offset") Integer offset);

	/**
	 * Get a list of categories used to tag items in Spotify (on, for example,
	 * the Spotify player’s “Browse” tab).
	 * 
	 * @return {@link Categories}
	 */
	@RequestLine("GET /v1/browse/categories")
	Categories categories();

	/**
	 * Get a list of categories used to tag items in Spotify (on, for example,
	 * the Spotify player’s “Browse” tab).
	 * 
	 * @param locale
	 *            The desired language, consisting of a lowercase ISO 639
	 *            language code and an uppercase ISO 3166-1 alpha-2 country
	 *            code, joined by an underscore. For example: es_MX, meaning
	 *            "Spanish (Mexico)". Provide this parameter if you want the
	 *            results returned in a particular language (where available).
	 * 
	 * @param country
	 *            A country: an ISO 3166-1 alpha-2 country code. Provide this
	 *            parameter if you want the list of returned items to be
	 *            relevant to a particular country. If omitted, the returned
	 *            items will be relevant to all countries.
	 * @return {@link Categories}
	 */
	@RequestLine("GET /v1/browse/categories?locale={locale}&country={country}")
	Categories categories(@Param("locale") String locale, @Param("country") String country);

	/**
	 * Get a list of categories used to tag items in Spotify (on, for example,
	 * the Spotify player’s “Browse” tab).
	 * 
	 * @param limit
	 *            The maximum number of items to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first item to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of items.
	 * @return {@link Categories}
	 */
	@RequestLine("GET /v1/browse/categories?limit={limit}&offset={offset}")
	Categories categories(@Param("limit") Integer limit, @Param("offset") Integer offset);

	/**
	 * Get a list of categories used to tag items in Spotify (on, for example,
	 * the Spotify player’s “Browse” tab).
	 * 
	 * @param locale
	 *            The desired language, consisting of a lowercase ISO 639
	 *            language code and an uppercase ISO 3166-1 alpha-2 country
	 *            code, joined by an underscore. For example: es_MX, meaning
	 *            "Spanish (Mexico)". Provide this parameter if you want the
	 *            results returned in a particular language (where available).
	 * 
	 * @param country
	 *            A country: an ISO 3166-1 alpha-2 country code. Provide this
	 *            parameter if you want the list of returned items to be
	 *            relevant to a particular country. If omitted, the returned
	 *            items will be relevant to all countries.
	 * @param limit
	 *            The maximum number of items to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first item to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of items.
	 * @return {@link Categories}
	 */
	@RequestLine("GET /v1/browse/categories?locale={locale}&country={country}&limit={limit}&offset={offset}")
	Categories categories(@Param("locale") String locale, @Param("country") String country,
			@Param("limit") Integer limit, @Param("offset") Integer offset);

	/**
	 * Get a single category used to tag items in Spotify (on, for example, the
	 * Spotify player’s “Browse” tab).
	 * 
	 * @param categoryId
	 *            The <a href=
	 *            "https://developer.spotify.com/web-api/user-guide/#spotify-uris-and-ids">Spotify
	 *            category ID</a> for the category.
	 * @return {@link Category}
	 */
	@RequestLine("GET /v1/browse/categories/{category_id}")
	Category category(@Param("category_id") String categoryId);

	/**
	 * Get a single category used to tag items in Spotify (on, for example, the
	 * Spotify player’s “Browse” tab).
	 * 
	 * @param categoryId
	 *            The <a href=
	 *            "https://developer.spotify.com/web-api/user-guide/#spotify-uris-and-ids">Spotify
	 *            category ID</a> for the category.
	 * @param locale
	 *            The desired language, consisting of a lowercase ISO 639
	 *            language code and an uppercase ISO 3166-1 alpha-2 country
	 *            code, joined by an underscore. For example: es_MX, meaning
	 *            "Spanish (Mexico)". Provide this parameter if you want the
	 *            results returned in a particular language (where available).
	 * 
	 * @param country
	 *            A country: an ISO 3166-1 alpha-2 country code. Provide this
	 *            parameter if you want the list of returned items to be
	 *            relevant to a particular country. If omitted, the returned
	 *            items will be relevant to all countries.
	 * @return {@link Category}
	 */
	@RequestLine("GET /v1/browse/categories/{category_id}?locale={locale}&country={country}")
	Category category(@Param("category_id") String categoryId, @Param("locale") String locale,
			@Param("country") String country);

	/**
	 * Get a list of Spotify playlists tagged with a particular category.
	 * 
	 * @param categoryId
	 *            The <a href=
	 *            "https://developer.spotify.com/web-api/user-guide/#spotify-uris-and-ids">Spotify
	 *            category ID</a> for the category.
	 * @return {@link Playlists}
	 */
	@RequestLine("GET /v1/browse/categories/{category_id}/playlists")
	Playlists categoryPlaylists(@Param("category_id") String categoryId);

	/**
	 * Get a list of Spotify playlists tagged with a particular category.
	 * 
	 * @param categoryId
	 *            The <a href=
	 *            "https://developer.spotify.com/web-api/user-guide/#spotify-uris-and-ids">Spotify
	 *            category ID</a> for the category.
	 * @param country
	 *            A country: an ISO 3166-1 alpha-2 country code.
	 * @return {@link Playlists}
	 */
	@RequestLine("GET /v1/browse/categories/{category_id}/playlists?country={country}")
	Playlists categoryPlaylists(@Param("category_id") String categoryId, @Param("country") String country);

	/**
	 * Get a list of Spotify playlists tagged with a particular category.
	 * 
	 * @param categoryId
	 *            The <a href=
	 *            "https://developer.spotify.com/web-api/user-guide/#spotify-uris-and-ids">Spotify
	 *            category ID</a> for the category.
	 * @param limit
	 *            The maximum number of items to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first item to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of items.
	 * @return {@link Playlists}
	 */
	@RequestLine("GET /v1/browse/categories/{category_id}/playlists?limit={limit}&offset={offset}")
	Playlists categoryPlaylists(@Param("category_id") String categoryId, @Param("limit") Integer limit,
			@Param("offset") Integer offset);

	/**
	 * Get a list of Spotify playlists tagged with a particular category.
	 * 
	 * @param categoryId
	 *            The <a href=
	 *            "https://developer.spotify.com/web-api/user-guide/#spotify-uris-and-ids">Spotify
	 *            category ID</a> for the category.
	 * @param country
	 *            A country: an ISO 3166-1 alpha-2 country code.
	 * @param limit
	 *            The maximum number of items to return. Default: 20. Minimum:
	 *            1. Maximum: 50.
	 * @param offset
	 *            The index of the first item to return. Default: 0 (the first
	 *            object). Use with limit to get the next set of items.
	 * @return {@link Playlists}
	 */
	@RequestLine("GET /v1/browse/categories/{category_id}/playlists?country={country}&limit={limit}&offset={offset}")
	Playlists categoryPlaylists(@Param("category_id") String categoryId, @Param("country") String country,
			@Param("limit") Integer limit, @Param("offset") Integer offset);

	// TODO
	// void recommendations();
}
