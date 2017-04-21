package org.springframework.social.spotify.api.operations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.social.spotify.api.Artist;
import org.springframework.social.spotify.api.CursorPaging;

import feign.Client;
import feign.Request;
import feign.Response;

public class FollowOperationsTest extends AbstractOperationsTest<FollowOperations> {

	public FollowOperationsTest() {
		super(FollowOperations.class);
	}

	@Test
	public void testFollowingArtists() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("followingArtists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET", "/v1/me/following?type=artist", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		CursorPaging<Artist> actual = followOperations.followingArtists();

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testFollowingArtistsLimitAfter() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("followingArtists.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/me/following?type=artist&limit=20&after=0aV6DOiouImYTqrR5YlIqx", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String after = "0aV6DOiouImYTqrR5YlIqx";
		CursorPaging<Artist> actual = followOperations.followingArtists(20, after);

		Assert.assertNotNull(actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testFollowArtist() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("PUT",
				"/v1/me/following?type=artist&ids=74ASZWbe4lXaubB36ztrGX%2C08td7MxkoHQkXnWAYD8d6Q", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String id1 = "74ASZWbe4lXaubB36ztrGX";
		String id2 = "08td7MxkoHQkXnWAYD8d6Q";

		followOperations.followArtist(id1, id2);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testUnfollowArtist() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("DELETE",
				"/v1/me/following?type=artist&ids=74ASZWbe4lXaubB36ztrGX%2C08td7MxkoHQkXnWAYD8d6Q", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String id1 = "74ASZWbe4lXaubB36ztrGX";
		String id2 = "08td7MxkoHQkXnWAYD8d6Q";

		followOperations.unfollowArtist(id1, id2);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testIsFollowingArtist() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("isFollowingArtist.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/me/following/contains?type=artist&ids=74ASZWbe4lXaubB36ztrGX%2C08td7MxkoHQkXnWAYD8d6Q", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String id1 = "74ASZWbe4lXaubB36ztrGX";
		String id2 = "08td7MxkoHQkXnWAYD8d6Q";

		Boolean[] actual = followOperations.isFollowingArtist(id1, id2);

		Boolean[] expected = expected("isFollowingArtist.json", Boolean[].class);
		Assert.assertNotNull(actual);
		Assert.assertArrayEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	
	@Test
	public void testFollowUser() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("PUT",
				"/v1/me/following?type=user&ids=exampleuser01", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String id1 = "exampleuser01";

		followOperations.followUser(id1);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testUnfollowUser() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("DELETE",
				"/v1/me/following?type=user&ids=exampleuser01", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String id1 = "exampleuser01";

		followOperations.unfollowUser(id1);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testIsFollowingUser() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = response("isFollowingUser.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/me/following/contains?type=user&ids=exampleuser01%2Cexampleuser02", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String id1 = "exampleuser01";
		String id2 = "exampleuser02";

		Boolean[] actual = followOperations.isFollowingUser(id1, id2);

		Boolean[] expected = expected("isFollowingUser.json", Boolean[].class);
		Assert.assertNotNull(actual);
		Assert.assertArrayEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testFollowPlaylistPublic() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();
		headers.put("Content-Type", Arrays.asList("application/json"));
		headers.put("Content-Length", Arrays.asList("17"));

		Response response = noContentResponse();
		byte[] body = loadContent("followPlaylistRequestPublic.json");
		ArgumentMatcher<Request> request = super.requestMatcher("PUT",
				"/v1/users/jmperezperez/playlists/2v3iNvBX8Ay1Gt2uXtUKUT/followers", headers, body);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String ownerId = "jmperezperez";
		String playlistId = "2v3iNvBX8Ay1Gt2uXtUKUT";

		followOperations.followPlaylist(ownerId, playlistId, true);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testFollowPlaylistPrivate() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();
		headers.put("Content-Type", Arrays.asList("application/json"));
		headers.put("Content-Length", Arrays.asList("18"));

		Response response = noContentResponse();
		byte[] body = loadContent("followPlaylistRequestPrivate.json");
		ArgumentMatcher<Request> request = super.requestMatcher("PUT",
				"/v1/users/jmperezperez/playlists/2v3iNvBX8Ay1Gt2uXtUKUT/followers", headers, body);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String ownerId = "jmperezperez";
		String playlistId = "2v3iNvBX8Ay1Gt2uXtUKUT";

		followOperations.followPlaylist(ownerId, playlistId, false);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testUnfollowPlaylist() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();

		Response response = noContentResponse();
		ArgumentMatcher<Request> request = super.requestMatcher("DELETE",
				"/v1/users/jmperezperez/playlists/2v3iNvBX8Ay1Gt2uXtUKUT/followers", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String ownerId = "jmperezperez";
		String playlistId = "2v3iNvBX8Ay1Gt2uXtUKUT";

		followOperations.unfollowPlaylist(ownerId, playlistId);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

	@Test
	public void testIsFollowingPlaylist() throws Exception {
		Client client = Mockito.mock(Client.class);

		Map<String, Collection<String>> headers = headers();
		
		Response response = response("isFollowingPlaylist.json");
		ArgumentMatcher<Request> request = super.requestMatcher("GET",
				"/v1/users/jmperezperez/playlists/2v3iNvBX8Ay1Gt2uXtUKUT/followers/contains?ids=possan%2Celogain", headers);

		Mockito.when(client.execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()))).thenReturn(response);

		FollowOperations followOperations = builder(client);

		String id1 = "possan";
		String id2 = "elogain";
		String ownerId = "jmperezperez";
		String playlistId = "2v3iNvBX8Ay1Gt2uXtUKUT";

		Boolean[] actual = followOperations.isFollowingPlaylist(ownerId, playlistId, id1, id2);

		Boolean[] expected = expected("isFollowingPlaylist.json", Boolean[].class);
		Assert.assertNotNull(actual);
		Assert.assertArrayEquals(expected, actual);

		Mockito.verify(client).execute(Mockito.argThat(request), Mockito.argThat(optionsMatcher()));
	}

}
