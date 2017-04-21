package org.springframework.social.spotify.api.operations.matcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.mockito.ArgumentMatcher;
import org.springframework.social.spotify.api.impl.SpotifyTemplate;

import feign.Request;

public class RequestMatcher implements ArgumentMatcher<Request> {

	private String method;
	private String url;
	private Map<String, Collection<String>> headers;
	private byte[]  body;

	public RequestMatcher(String method, String url, Map<String, Collection<String>> headers) {
		this.method = method;
		this.url = url;
		this.headers = headers;
	}

	public RequestMatcher(String method, String url, Map<String, Collection<String>> headers, byte[] body) {
		this.method = method;
		this.url = url;
		this.headers = headers;
		this.body = body;
	}

	@Override
	public boolean matches(Request argument) {

		boolean b = false;

		b = argument.url().equals(SpotifyTemplate.BASE_URL + this.url);
		if (b) {
			b = argument.method().equals(this.method);
		}

		if (b) {
			b = argument.headers().equals(this.headers);
		}

		if (b) {
			if (body != null) {
				b = Arrays.equals(body, argument.body());
			} else {
				b = argument.body() == null;
			}
		}

		return b;
	}

}