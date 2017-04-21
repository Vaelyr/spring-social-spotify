package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class AlbumSimplified {
	private String albumType;
	private ArtistSimplified[] artists; 
	private String[] availableMarkets;
	private ExternalUrl externalUrls;
	private String href;
	private String id;
	private Image[] images;
	private String name;
	private String type;
	private String uri;

}
