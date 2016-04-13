package com.klwork.spring.vertx.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractSettings {

	private static ObjectMapper mapper = new ObjectMapper();


	@Override
	public String toString() {
		try {
			return mapper.writeValueAsString(this);
		} catch ( Exception e ) {
			//return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
		return "";
	}
}
