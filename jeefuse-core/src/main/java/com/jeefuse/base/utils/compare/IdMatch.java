package com.jeefuse.base.utils.compare;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.jeefuse.base.model.IdEntity;

/**
 * 判断指定id的对象是否在集合中.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class IdMatch<T extends IdEntity> implements Match<String> {
	Map<String, T> matchMap = null;

	/**
	 *判断指定id的对象是否在集合中.
	 * @param collections
	 */
	public IdMatch(Collection<T> collections) {
		matchMap = new HashMap<String, T>();
		if (null != collections) {
			for (T idEntity : collections) {
				matchMap.put(idEntity.getId().toString(), idEntity);
			}
		}
	}

	public boolean isMatch(String id) {
		if (null != matchMap.get(id)) {
			return true;
		}
		return false;
	}

}
