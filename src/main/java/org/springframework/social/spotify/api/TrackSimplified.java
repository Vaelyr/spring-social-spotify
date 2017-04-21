package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class TrackSimplified {
	private ArtistSimplified[] artists;
	private String[] availableMarkets;
	private Integer discNumber;
	private Integer durationMs;
	private Boolean explict;
	private ExternalUrl externalUrls;
	private String href;
	private String id;
	private Boolean isPlayable;
	private TrackLink linkedFrom;
	private String name;
	private String previewUrl;
	private Integer trackNumber;
	private String type;
	private String uri;
	
}
