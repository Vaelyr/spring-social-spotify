package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class SavedTrack {
	private String addedAt;
	private Track track;
}
