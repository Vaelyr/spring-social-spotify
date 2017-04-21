package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class Cursor {
	private String after;
	private String before;
}
