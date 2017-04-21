package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class ArtistSimplified {
	private ExternalUrl externalUrls;
	private String href;
	private String id;
	private String name;
	private String type;
	private String uri;
}
