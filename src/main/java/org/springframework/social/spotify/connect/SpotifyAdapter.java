package org.springframework.social.spotify.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.spotify.api.Spotify;
import org.springframework.social.spotify.api.UserPrivate;

public class SpotifyAdapter implements ApiAdapter<Spotify> {

	@Override
	public UserProfile fetchUserProfile(Spotify spotify) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnectionValues(Spotify spotify, ConnectionValues values) {
//		UserPrivate me = spotify.userOperations().me();
//		
//		values.setProviderUserId(me.getId());
//		values.setDisplayName(me.getDisplayName());
	}

	@Override
	public boolean test(Spotify spotify) {
		try {
			spotify.isAuthorized();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	
	@Override
	public void updateStatus(Spotify spotify, String message) {
		// Nothing to do

	}

}
