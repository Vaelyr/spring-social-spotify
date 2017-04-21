package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class UserPublic {
//	private String birthdate;
//	private String country;
	private String displayName;
//	private String email;
	private ExternalUrl externalUrls;
	private Followers followers;
	private String href;
	private String id;
	private Image[] images;
//	private String product;
	private String type;
	private String uri;

}
