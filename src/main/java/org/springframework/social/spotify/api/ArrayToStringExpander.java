package org.springframework.social.spotify.api;

import org.apache.commons.lang.StringUtils;

import feign.Param.Expander;

public class ArrayToStringExpander implements Expander {

	@Override
	public String expand(Object value) {
		if (value instanceof Object[]) {
			Object[] array = (Object[]) value;
			if (array.length == 0) {
				throw new IllegalArgumentException("Value muest be not empty");
			}
			String s = StringUtils.join(array, ',');
			
			return s;
		}
		throw new IllegalArgumentException("Value muest be an array");

	}

}
