package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class Paging<T> {
	private String href;
	private T[] items;
	private Integer limit;
	private String next;
	private Integer offset;
	private String previous;
	private Integer total;
}
