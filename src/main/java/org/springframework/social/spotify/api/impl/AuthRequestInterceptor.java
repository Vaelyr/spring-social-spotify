package org.springframework.social.spotify.api.impl;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthRequestInterceptor implements RequestInterceptor {

	private String token;

	public AuthRequestInterceptor(String token) {
		this.token = token;
	}

	@Override
	public void apply(RequestTemplate template) {
		template.header("Authorization", "Bearer " + token);

	}

}
