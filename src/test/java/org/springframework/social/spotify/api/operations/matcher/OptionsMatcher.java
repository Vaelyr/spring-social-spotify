package org.springframework.social.spotify.api.operations.matcher;

import org.mockito.ArgumentMatcher;

import feign.Request.Options;

public class OptionsMatcher implements ArgumentMatcher<Options>{

	@Override
	public boolean matches(Options argument) {
		return true;
	}

}
