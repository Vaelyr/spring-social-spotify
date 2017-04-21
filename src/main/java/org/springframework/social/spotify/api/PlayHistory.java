package org.springframework.social.spotify.api;


import lombok.Data;

@Data
public class PlayHistory {
	private TrackSimplified track;
	private String playedAt;
	private Context context;
}
