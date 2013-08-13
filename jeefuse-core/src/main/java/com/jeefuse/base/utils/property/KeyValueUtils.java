package com.jeefuse.base.utils.property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyValueUtils {
	
	/**把KeyValue对象例表转化为以key为键,KeyValue为值的map.
	 */
	public static Map<String,KeyValue> toKeyValueMap(List<KeyValue> list){
		Map<String,KeyValue> map=new HashMap<String,KeyValue>();
		for(KeyValue kv:list){
			map.put(kv.getKey(), kv);
		}
		return map;
	}

}
