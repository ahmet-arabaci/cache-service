package com.ahmetarabaci.cacheservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheInspectService {
	
	@Autowired
	private CacheManager cacheManager;
	
	public String getCacheContents(String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		if (cache != null) {			
			return String.format("Cache info: %s | Content: '%s'", cache.getNativeCache().toString(), cache.get("customkey").toString());
		} else { 
			return String.format("'%s' cache couldn't found!", cacheName);
		}		
	}
}

