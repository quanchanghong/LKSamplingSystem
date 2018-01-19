package cn.com.lk.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheUtils {
	
	private static CacheManager cacheManager = CacheManager.create();//返回存在的单例manager
	
	public static Cache getCacheByName(String cacheName){
		return cacheManager.getCache(cacheName);
	}
	
	public static Element getElementByName(String cacheName,String elementName){
		return cacheManager.getCache(cacheName).get(elementName);
	}

}
