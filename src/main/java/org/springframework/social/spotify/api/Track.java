package org.springframework.social.spotify.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Track extends TrackSimplified {
	private AlbumSimplified album;
	private ExternalId externalIds;
	private Integer popularity;
}
