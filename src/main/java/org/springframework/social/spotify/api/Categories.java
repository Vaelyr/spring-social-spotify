package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class Categories {
	private Paging<Category> categories;
}
