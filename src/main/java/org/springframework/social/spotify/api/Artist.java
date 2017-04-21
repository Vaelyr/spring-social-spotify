package org.springframework.social.spotify.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class Artist extends ArtistSimplified {

	private ExternalUrl externalUrls;
	private Followers followers;
	private String[] genres;
	private Image[] images;
	private Integer popularity;
}
