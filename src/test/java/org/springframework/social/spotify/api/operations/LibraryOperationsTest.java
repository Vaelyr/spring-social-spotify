package org.springframework.social.spotify.api.operations;

import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.SavedAlbum;
import org.springframework.social.spotify.api.SavedTrack;

import feign.Client;
import feign.Request;
import feign.Response;

public class LibraryOperationsTest extends AbstractOperationsTest<LibraryOperations> {

	public LibraryOperationsTest() {
		super(LibraryOperations.class);
	}

	@Test
	public void testSaveTracks() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("PUT",
				"/v1/me/tracks?ids=4iV5W9uYEdYUVa79Axb7Rh%2C1301WleyT98MSxVHPZCA6M", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		String id1 = "4iV5W9uYEdYUVa79Axb7Rh";
		String id2 = "1301WleyT98MSxVHPZCA6M";

		libraryOperations.saveTracks(id1, id2);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSavedTracks() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("savedTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/tracks", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		Paging<SavedTrack> actual = libraryOperations.getSavedTracks();

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSavedTracksMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("savedTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/tracks?market=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		Paging<SavedTrack> actual = libraryOperations.getSavedTracks("BR");

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSavedTracksLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("savedTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/tracks?limit=2&offset=0", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		Paging<SavedTrack> actual = libraryOperations.getSavedTracks(2, 0);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSavedTracksLimitOffsetMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("savedTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/tracks?limit=2&offset=0&market=BR",
				headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		Paging<SavedTrack> actual = libraryOperations.getSavedTracks(2, 0, "BR");

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testRemoveSavedTracks() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("DELETE",
				"/v1/me/tracks?ids=4iV5W9uYEdYUVa79Axb7Rh%2C1301WleyT98MSxVHPZCA6M", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		String id1 = "4iV5W9uYEdYUVa79Axb7Rh";
		String id2 = "1301WleyT98MSxVHPZCA6M";

		libraryOperations.removeSavedTracks(id1, id2);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testIsSavedTrack() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("isSavedTrack.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/me/tracks/contains?ids=4iV5W9uYEdYUVa79Axb7Rh%2C1301WleyT98MSxVHPZCA6M", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		String id1 = "4iV5W9uYEdYUVa79Axb7Rh";
		String id2 = "1301WleyT98MSxVHPZCA6M";

		Boolean[] actual = libraryOperations.isSavedTracks(id1, id2);

		Boolean[] expected = expected("isSavedTrack.json", Boolean[].class);
		Assert.assertNotNull(actual);
		Assert.assertArrayEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testSaveAlbum() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("PUT",
				"/v1/me/albums?ids=4iV5W9uYEdYUVa79Axb7Rh%2C1301WleyT98MSxVHPZCA6M", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		String id1 = "4iV5W9uYEdYUVa79Axb7Rh";
		String id2 = "1301WleyT98MSxVHPZCA6M";

		libraryOperations.saveAlbums(id1, id2);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSavedAlbums() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("savedAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/albums", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		Paging<SavedAlbum> actual = libraryOperations.getSavedAlbums();

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSavedAlbumsMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("savedAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/albums?market=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		Paging<SavedAlbum> actual = libraryOperations.getSavedAlbums("BR");

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSavedAlbumsLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("savedAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/albums?limit=2&offset=0", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		Paging<SavedAlbum> actual = libraryOperations.getSavedAlbums(2, 0);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSavedAlbumsLimitOffsetMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("savedAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/albums?limit=2&offset=0&market=BR",
				headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		Paging<SavedAlbum> actual = libraryOperations.getSavedAlbums(2, 0, "BR");

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testRemoveSavedAlbums() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("DELETE",
				"/v1/me/albums?ids=4iV5W9uYEdYUVa79Axb7Rh%2C1301WleyT98MSxVHPZCA6M", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		String id1 = "4iV5W9uYEdYUVa79Axb7Rh";
		String id2 = "1301WleyT98MSxVHPZCA6M";

		libraryOperations.removeSavedAlbums(id1, id2);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testIsSavedAlbums() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("isSavedAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/me/albums/contains?ids=4iV5W9uYEdYUVa79Axb7Rh%2C1301WleyT98MSxVHPZCA6M", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		LibraryOperations libraryOperations = builder(client);

		String id1 = "4iV5W9uYEdYUVa79Axb7Rh";
		String id2 = "1301WleyT98MSxVHPZCA6M";

		Boolean[] actual = libraryOperations.isSavedAlbums(id1, id2);

		Boolean[] expected = expected("isSavedAlbums.json", Boolean[].class);
		Assert.assertNotNull(actual);
		Assert.assertArrayEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

}
