package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class PlaylistSimplified {
	private Boolean collaborative;
	private ExternalUrl externalUrls;
	private String href;
	private String id;
	private Image[] images;
	private String name;
	private UserPublic owner;
	private Boolean _public;
	private String snapshotId;
//	private String tracks; // TODO
	private String type;
	private String uri;
}
