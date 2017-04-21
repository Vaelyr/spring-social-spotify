package org.springframework.social.spotify.api.operations;

import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.social.spotify.api.AlbumSimplified;
import org.springframework.social.spotify.api.AlbumType;
import org.springframework.social.spotify.api.Artist;
import org.springframework.social.spotify.api.Artists;
import org.springframework.social.spotify.api.Paging;
import org.springframework.social.spotify.api.Tracks;

import feign.Client;
import feign.Request;
import feign.Response;

public class ArtistsOperationsTest extends AbstractOperationsTest<ArtistsOperations> {

	public ArtistsOperationsTest() {
		super(ArtistsOperations.class);
	}

	@Test
	public void testGetArtist() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artist.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/artists/0OdUWJ0sBjDrqHygGUXeCF", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id = "0OdUWJ0sBjDrqHygGUXeCF";

		Artist actual = artistsOperations.getArtist(id);

		Artist expected = expected("artist.json", Artist.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetSeveralArtist() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/?ids=0oSGxfWSnnOXhD2fKuz2Gy%2C3dBVyJ7JuOMt4GE9607Qin", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "0oSGxfWSnnOXhD2fKuz2Gy";
		String id2 = "3dBVyJ7JuOMt4GE9607Qin";

		Artists actual = artistsOperations.getSeveralArtists(id1, id2);

		Artists expected = expected("artists.json", Artists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetArtistAlbums() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artistAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums",
				headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "1vCWHaC5f2uS3yhpwWbIA6";

		Paging<AlbumSimplified> actual = artistsOperations.getArtistAlbums(id1);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetArtistAlbumsType() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artistAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums?album_type=single", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "1vCWHaC5f2uS3yhpwWbIA6";

		Paging<AlbumSimplified> actual = artistsOperations.getArtistAlbums(id1, AlbumType.single);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetArtistAlbumsMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artistAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums?market=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "1vCWHaC5f2uS3yhpwWbIA6";

		Paging<AlbumSimplified> actual = artistsOperations.getArtistAlbums(id1, "BR");

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetArtistAlbumsMarketType() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artistAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums?market=BR&album_type=album%2Csingle", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "1vCWHaC5f2uS3yhpwWbIA6";

		Paging<AlbumSimplified> actual = artistsOperations.getArtistAlbums(id1, "BR", AlbumType.album,
				AlbumType.single);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetArtistAlbumsLimitOffset() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artistAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums?limit=1&offset=2", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "1vCWHaC5f2uS3yhpwWbIA6";

		Paging<AlbumSimplified> actual = artistsOperations.getArtistAlbums(id1, 1, 2);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetArtistAlbumsLimitOffsetType() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artistAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums?limit=1&offset=2&album_type=compilation", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "1vCWHaC5f2uS3yhpwWbIA6";

		Paging<AlbumSimplified> actual = artistsOperations.getArtistAlbums(id1, 1, 2, AlbumType.compilation);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetArtistAlbumsLimitOffsetMarket() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artistAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums?limit=1&offset=2&market=BR", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "1vCWHaC5f2uS3yhpwWbIA6";

		Paging<AlbumSimplified> actual = artistsOperations.getArtistAlbums(id1, 1, 2, "BR");

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetArtistAlbumsLimitOffsetMarketType() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("artistAlbums.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/1vCWHaC5f2uS3yhpwWbIA6/albums?limit=1&offset=2&market=BR&album_type=appears_on", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "1vCWHaC5f2uS3yhpwWbIA6";

		Paging<AlbumSimplified> actual = artistsOperations.getArtistAlbums(id1, 1, 2, "BR", AlbumType.appears_on);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetTopTracks() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("topTracks.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/43ZHCT0cAZBISjO8DG9PnE/top-tracks?country=SE", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "43ZHCT0cAZBISjO8DG9PnE";

		Tracks actual = artistsOperations.getTopTracks(id1, "SE");

		Tracks expected = expected("topTracks.json", Tracks.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testGetRelatedArtists() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("relatedArtists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/artists/43ZHCT0cAZBISjO8DG9PnE/related-artists", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		ArtistsOperations artistsOperations = builder(client);

		String id1 = "43ZHCT0cAZBISjO8DG9PnE";

		Artists actual = artistsOperations.getRelatedArtists(id1);

		Artists expected = expected("relatedArtists.json", Artists.class);
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

}
