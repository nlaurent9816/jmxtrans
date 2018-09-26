package com.googlecode.jmxtrans.model.output.influxdb_tags;

import java.util.Map;

import com.googlecode.jmxtrans.model.Result;

public final class CustomTags implements TagsProvider {
	
	private final Map<String, String> tags;
	
	public CustomTags(Map<String, String> tags) {
		this.tags = tags;
	}

	@Override
	public final Map<String, String> getTags(Result result) {
		return tags;
	}

}
