package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class SavedAlbum {
	private String addedAt;
	private Album album;
}
