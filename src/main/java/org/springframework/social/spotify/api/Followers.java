package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class Followers {
	private String href;
	private Integer total;
}
