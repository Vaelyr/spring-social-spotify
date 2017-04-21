package org.springframework.social.spotify.api.operations;

import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.social.spotify.api.AlbumSimplified;
import org.springframework.social.spotify.api.Categories;
import org.springframework.social.spotify.api.Category;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.Playlists;

import feign.Client;
import feign.Request;
import feign.Response;

public class BrowseOperationsTest extends AbstractOperationsTest<BrowseOperations> {

	public BrowseOperationsTest() {
		super(BrowseOperations.class);
	}

	@Test
	public void testFeaturedPlaylists() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("featuredPlaylists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/featured-playlists", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Playlists actual = browseOperations.featuredPlaylists();

		Playlists expected = expected("featuredPlaylists.json", Playlists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testFeaturedPlaylistsLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("featuredPlaylists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/featured-playlists?limit=2&offset=1",
				headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Playlists actual = browseOperations.featuredPlaylists(2, 1);

		Playlists expected = expected("featuredPlaylists.json", Playlists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testFeaturedPlaylistsLocaleCountry() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("featuredPlaylists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/browse/featured-playlists?locale=pt_BR&country=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Playlists actual = browseOperations.featuredPlaylists("pt_BR", "BR");

		Playlists expected = expected("featuredPlaylists.json", Playlists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testNewReleases() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("newReleases.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/new-releases", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Paging<AlbumSimplified> actual = browseOperations.newReleases();

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testNewReleasesCountry() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("newReleases.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/new-releases?country=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Paging<AlbumSimplified> actual = browseOperations.newReleases("BR");

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testNewReleasesLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("newReleases.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/new-releases?limit=2&offset=1",
				headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Paging<AlbumSimplified> actual = browseOperations.newReleases(2, 1);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testNewReleasesLimitOffsetCountry() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("newReleases.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/browse/new-releases?country=BR&limit=2&offset=1", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Paging<AlbumSimplified> actual = browseOperations.newReleases("BR", 2, 1);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategories() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("categories.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Categories actual = browseOperations.categories();

		Categories expected = expected("categories.json", Categories.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategoriesLocaleCountry() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("categories.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories?locale=pt_BR&country=BR",
				headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Categories actual = browseOperations.categories("pt_BR", "BR");

		Categories expected = expected("categories.json", Categories.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategoriesLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("categories.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories?limit=2&offset=1",
				headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Categories actual = browseOperations.categories(2, 1);

		Categories expected = expected("categories.json", Categories.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategoriesLocaleCountryLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("categories.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/browse/categories?locale=pt_BR&country=BR&limit=2&offset=1", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Categories actual = browseOperations.categories("pt_BR", "BR", 2, 1);

		Categories expected = expected("categories.json", Categories.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategory() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("category.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories/party", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Category actual = browseOperations.category("party");

		Category expected = expected("category.json", Category.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategoryLocaleCountry() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("category.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories/party?locale=pt_BR&country=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Category actual = browseOperations.category("party", "pt_BR", "BR");

		Category expected = expected("category.json", Category.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategoryPlaylists() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("categoryPlaylists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories/party/playlists", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Playlists actual = browseOperations.categoryPlaylists("party");

		Playlists expected = expected("categoryPlaylists.json", Playlists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategoryPlaylistsCountry() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("categoryPlaylists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories/party/playlists?country=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Playlists actual = browseOperations.categoryPlaylists("party", "BR");

		Playlists expected = expected("categoryPlaylists.json", Playlists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategoryPlaylistsLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("categoryPlaylists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories/party/playlists?limit=2&offset=1", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Playlists actual = browseOperations.categoryPlaylists("party", 2, 1);

		Playlists expected = expected("categoryPlaylists.json", Playlists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testCategoryPlaylistsCountryLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("categoryPlaylists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/browse/categories/party/playlists?country=BR&limit=2&offset=1", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		BrowseOperations browseOperations = builder(client);

		Playlists actual = browseOperations.categoryPlaylists("party", "BR", 2, 1);

		Playlists expected = expected("categoryPlaylists.json", Playlists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

}
