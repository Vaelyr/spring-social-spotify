package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class Context {
	private String type;
	private String href;
	private ExternalUrl externalUrls;
	private String uri;
}
