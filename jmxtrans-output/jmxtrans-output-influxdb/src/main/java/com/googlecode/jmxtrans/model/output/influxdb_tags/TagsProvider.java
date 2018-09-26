package com.googlecode.jmxtrans.model.output.influxdb_tags;

import java.util.Map;

import com.googlecode.jmxtrans.model.Result;

/**
 * 
 * @author nlaurent9816
 * 
 * Simple interface for provider of tags for InfluxDB.
 *
 */
public interface TagsProvider {
	
	public Map<String, String> getTags(Result result);
	
}
