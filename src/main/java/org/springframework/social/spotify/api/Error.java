package org.springframework.social.spotify.api;

import lombok.Data;

@Data
public class Error {
	private String status;
	private String message;
}
