package com.obscured.phonegap.build.common;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

	public static Map<String, String> OptionsToMap(String[] opts) {
		Map<String, String> map = IntStream.range(0, opts.length / 2)
		                                   .mapToObj(m -> new AbstractMap.SimpleEntry<>(2 * m, 2 * m + 1))
		                                   .collect(Collectors.toMap(
				                                   k -> opts[k.getKey()],
				                                   v -> opts[v.getValue()]));
		return map;
	}
}
