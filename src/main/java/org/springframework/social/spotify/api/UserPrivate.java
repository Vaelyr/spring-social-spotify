package org.springframework.social.spotify.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class UserPrivate extends UserPublic {

	private String birthdate;
	private String country;
	private String email;
	private String product;
}
