package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class CursorPaging<T> {
	private String href;
	private T[] items;
	private Integer limit;
	private String next;
	private Cursor cursors;
	private Integer total;
}
