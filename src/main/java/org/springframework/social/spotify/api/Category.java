package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class Category {

	private String href;
	private Image[] icons;
	private String id;
	private String name;
}
