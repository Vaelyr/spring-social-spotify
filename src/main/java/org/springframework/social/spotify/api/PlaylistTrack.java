package org.springframework.social.spotify.api;


import lombok.Data;

@Data
public class PlaylistTrack {
	private String addedAt;
	private String addedBy;
	private Boolean isLocal;
	private Track track;
}
