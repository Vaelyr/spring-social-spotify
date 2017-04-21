package org.springframework.social.spotify.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Album extends AlbumSimplified {
	private Copyright[] copyrights;
	private ExternalId externalIds;
	private String[] genres;
	private String label;
	private Integer popularity;
	private String releaseDate;
	private String releaseDatePrecision;
	private Paging<TrackSimplified> tracks;
}
