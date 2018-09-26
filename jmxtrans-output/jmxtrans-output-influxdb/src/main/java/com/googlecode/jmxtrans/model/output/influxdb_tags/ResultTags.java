package com.googlecode.jmxtrans.model.output.influxdb_tags;

import static com.google.common.collect.Maps.newHashMap;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;
import com.googlecode.jmxtrans.model.Result;
import com.googlecode.jmxtrans.model.ResultAttribute;
import com.googlecode.jmxtrans.model.ResultAttributes;

public final class ResultTags implements TagsProvider {
	
	private static final Logger log = LoggerFactory.getLogger(ResultTags.class);
	
	private final ImmutableSet<ResultAttribute> resultTagsSet;
	
	public ResultTags(List<String> resultTags) {
		
		if (resultTags == null) {
			resultTagsSet = ImmutableSet.copyOf(ResultAttributes.values());
		} else {
			resultTagsSet = ResultAttributes.forNames(resultTags);
		}
		log.debug("Result Tags to write set to: {}", resultTagsSet);

	}

	@Override
	public Map<String, String> getTags(Result result) {
		
		Map<String, String> resultTagMap = newHashMap();
		for (ResultAttribute resultAttribute : resultTagsSet) {
			resultAttribute.addTo(resultTagMap, result);
		}
		return resultTagMap;
	}

}
