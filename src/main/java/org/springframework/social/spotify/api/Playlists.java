package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class Playlists {
	private String message;
	private Paging<PlaylistSimplified> playlists;
}
