package org.springframework.social.spotify.api.operations;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.mockito.ArgumentMatcher;
import org.springframework.social.spotify.api.impl.AuthRequestInterceptor;
import org.springframework.social.spotify.api.operations.matcher.OptionsMatcher;
import org.springframework.social.spotify.api.operations.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import feign.Client;
import feign.Feign;
import feign.Request;
import feign.RequestInterceptor;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public abstract class AbstractOperationsTest<T> {
	private static final String ACCESS_TOKEN = "TOKEN";
	private Class<T> clazz;
	private ObjectMapper mapper;
	private OptionsMatcher optionsMatcher;

	protected AbstractOperationsTest(Class<T> clazz) {
		this.clazz = clazz;
		
		this.optionsMatcher = new OptionsMatcher();
		
		this.mapper = new ObjectMapper();
		
		this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	}

	protected final T builder(Client client) {

		RequestInterceptor interceptor = new AuthRequestInterceptor(ACCESS_TOKEN);

		Decoder decoder = new JacksonDecoder(mapper);
		Encoder encoder = new JacksonEncoder(mapper);

		return Feign.builder().client(client).encoder(encoder).decoder(decoder).requestInterceptor(interceptor)
				.target(clazz, "https://api.spotify.com");

	}

	protected Map<String, Collection<String>> headers() {
		Map<String, Collection<String>> headers = new HashMap<>();
		headers.put("Authorization",Arrays.asList("Bearer "+ACCESS_TOKEN));
		
		return headers;

	}

	protected final Response noContentResponse() throws Exception {
		return Response.builder().status(204).reason("No content").headers(Collections.emptyMap()).build();
	}

	protected final Response response(String content) throws Exception {
		byte[] text = Files.readAllBytes(Paths.get(AlbumsOperationsTest.class.getResource(content).toURI()));
		return Response.builder().status(200).reason("OK").headers(Collections.emptyMap()).body(text).build();
	}
	
	protected final ArgumentMatcher<Request> requestMatcher(String method, String url, Map<String, Collection<String>> headers) {
		ArgumentMatcher<Request> requestMatcher = new RequestMatcher(method, url, headers);
		
		return requestMatcher;
	}
	
	protected final ArgumentMatcher<Request> requestMatcher(String method, String url, Map<String, Collection<String>> headers, byte[] body) {
		ArgumentMatcher<Request> requestMatcher = new RequestMatcher(method, url, headers, body);
		
		return requestMatcher;
	}

	protected final <Z> Z expected(String resource, Class<Z> clazz) throws Exception {
		byte[] text = Files.readAllBytes(Paths.get(AlbumsOperationsTest.class.getResource(resource).toURI()));
		return mapper.readValue(text, clazz);
	}
	
	protected final OptionsMatcher optionsMatcher() {
		return this.optionsMatcher;
	}
	
	protected final byte[] loadContent(String content) throws Exception {
		byte[] text = Files.readAllBytes(Paths.get(AlbumsOperationsTest.class.getResource(content).toURI()));
		
		return text;
	}
}
