package org.springframework.social.spotify.api.operations;

import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.social.spotify.api.Album;
import org.springframework.social.spotify.api.Albums;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.TrackSimplified;

import feign.Client;
import feign.Request;
import feign.Response;

public class AlbumsOperationsTest extends AbstractOperationsTest<AlbumsOperations> {

	public AlbumsOperationsTest() {
		super(AlbumsOperations.class);
	}

	@Test
	public void testGetAlbum() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("album.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/albums/2BTZIqw0ntH9MvilQ3ewNY", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		AlbumsOperations albumsOperations = builder(client);

		String id = "2BTZIqw0ntH9MvilQ3ewNY";

		Album actual = albumsOperations.getAlbum(id);

		Album expected = expected("album.json", Album.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}
	
	@Test
	public void testGetAlbumMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("album.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/albums/2BTZIqw0ntH9MvilQ3ewNY?market=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		AlbumsOperations albumsOperations = builder(client);

		String id = "2BTZIqw0ntH9MvilQ3ewNY";
		String market = "BR";

		Album actual = albumsOperations.getAlbum(id, market);

		Album expected = expected("album.json", Album.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}
	
	@Test
	public void testGetAlbums() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("albums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/albums/?ids=41MnTivkwTO3UUJ8DrqEJJ%2C2BTZIqw0ntH9MvilQ3ewNY", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		AlbumsOperations albumsOperations = builder(client);

		String id1 = "41MnTivkwTO3UUJ8DrqEJJ";
		String id2 = "2BTZIqw0ntH9MvilQ3ewNY";

		Albums actual = albumsOperations.getSeveralAlbums(id1, id2);

		Albums expected = expected("albums.json", Albums.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
		
	}

	@Test
	public void testGetAlbumsMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("albums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/albums/?ids=41MnTivkwTO3UUJ8DrqEJJ%2C2BTZIqw0ntH9MvilQ3ewNY&market=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		AlbumsOperations albumsOperations = builder(client);

		String id1 = "41MnTivkwTO3UUJ8DrqEJJ";
		String id2 = "2BTZIqw0ntH9MvilQ3ewNY";
		String market = "BR";

		Albums actual = albumsOperations.getSeveralAlbumsMarket(market, id1, id2);

		Albums expected = expected("albums.json", Albums.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
		
	}


	@Test
	public void testGetAlbumTracks() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("albumTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/albums/6akEvsycLGftJxYudPjmqK/tracks", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		AlbumsOperations albumsOperations = builder(client);

		String id1 = "6akEvsycLGftJxYudPjmqK";

		Paging<TrackSimplified> actual = albumsOperations.getAlbumTracks(id1);

		Assert.assertNotNull(actual);
		
		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
		
	}

	@Test
	public void testGetAlbumTracksMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("albumTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/albums/6akEvsycLGftJxYudPjmqK/tracks?market=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		AlbumsOperations albumsOperations = builder(client);

		String id1 = "6akEvsycLGftJxYudPjmqK";
		String market = "BR";

		Paging<TrackSimplified> actual = albumsOperations.getAlbumTracks(id1, market);

		Assert.assertNotNull(actual);
		
		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
		
	}

	@Test
	public void testGetAlbumTracksLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("albumTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/albums/6akEvsycLGftJxYudPjmqK/tracks?limit=2&offset=1", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		AlbumsOperations albumsOperations = builder(client);

		String id1 = "6akEvsycLGftJxYudPjmqK";

		Paging<TrackSimplified> actual = albumsOperations.getAlbumTracks(id1, 2, 1);

		Assert.assertNotNull(actual);
		
		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
		
	}

	@Test
	public void testGetAlbumTracksLimitOffsetMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("albumTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/albums/6akEvsycLGftJxYudPjmqK/tracks?limit=2&offset=1&market=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		AlbumsOperations albumsOperations = builder(client);

		String id1 = "6akEvsycLGftJxYudPjmqK";

		Paging<TrackSimplified> actual = albumsOperations.getAlbumTracks(id1, 2, 1, "BR");

		Assert.assertNotNull(actual);
		
		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
		
	}

}
