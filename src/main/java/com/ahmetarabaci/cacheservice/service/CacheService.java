package com.ahmetarabaci.cacheservice.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
		
	private String data = "DATA";
		
	public String getData() {	
		return data;
	}
	
	public String updateData(String data) {
		this.data = data;
		return this.data;
	}
	
	@Cacheable(value = "rediscache", key = "'customkey'")
	public String getCache() {	
		return this.data;
	}
	
	@CachePut(value = "rediscache", key = "'customkey'")
	public String updateCache(String data) {
		this.data = data;
		return data;
	}
		
	@CacheEvict(value = "rediscache", key = "'customkey'")
	public String clearCache() {
		return "Cache has been cleared.";
	}
					
}

