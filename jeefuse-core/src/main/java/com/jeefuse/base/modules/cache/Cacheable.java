package com.jeefuse.base.modules.cache;

import java.io.Serializable;

/**
 * 缓存.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface Cacheable<T extends Serializable> {

	/**
	 * 添加缓存对象
	 * 
	 * @param key
	 *            缓存KEY
	 * @param cacheObj
	 *            缓存对象
	 */
	public void put(final String key, T obj);

	/**
	 * 获取缓存对象
	 * 
	 * @param key
	 *            缓存KEY
	 * @return 缓存对象
	 */
	public T get(final String key);

	/**
	 * 移除指定KEY缓存对象
	 * 
	 * @param key
	 *            缓存KEY
	 */
	public void remove(final String key);
}
