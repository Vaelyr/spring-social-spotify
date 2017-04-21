package org.springframework.social.spotify.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Playlist extends PlaylistSimplified {
	private String description;
	private Followers followers;
	private TrackSimplified[] tracks;
	
}
