package com.jeefuse.base.modules.cache;

import net.sf.ehcache.CacheManager;

/**
 * 缓存访问管理.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface CacheManagerable {

	/**
	 * 返回缓存管理.
	 */
	public CacheManager getCacheManager();

	/**
	 * 刷新缓存.
	 */
	public void refreshCache();

	/**
	 * 清除缓存.
	 */
	public void destroyCache();

}
