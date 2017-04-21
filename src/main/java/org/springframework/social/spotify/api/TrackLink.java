package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class TrackLink {
	private ExternalUrl externalUrls;
	private String href;
	private String id;
	private String type;
	private String uri;
}
