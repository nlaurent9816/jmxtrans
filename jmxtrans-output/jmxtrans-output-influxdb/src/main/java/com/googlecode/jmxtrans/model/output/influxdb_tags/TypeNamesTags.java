package com.googlecode.jmxtrans.model.output.influxdb_tags;

import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;

import com.googlecode.jmxtrans.model.Result;

public final class TypeNamesTags implements TagsProvider {
	
	private final List<String> typeNames;

	public TypeNamesTags(List<String> typeNames) {
		this.typeNames=typeNames;
	}
	
	@Override
	public Map<String, String> getTags(Result result) {
		
		Map<String, String> resultTagMap = newHashMap();
		
		Map<String, String> typeNameValueMap = result.getTypeNameMap();
		for (String typeToTag : this.typeNames) {
			if (typeNameValueMap.containsKey(typeToTag)) {
				resultTagMap.put(typeToTag, typeNameValueMap.get(typeToTag));
			}
		}
		return resultTagMap;
	}

}
