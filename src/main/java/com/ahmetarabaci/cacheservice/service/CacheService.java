package com.ahmetarabaci.cacheservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.ahmetarabaci.cacheservice.repository.OracleRepository;

@Service
public class CacheService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);
	
	@Autowired
	private OracleRepository repo;	
		
	public int insertData(String key, String val) {
		return repo.insertData(key, val);		
	}

	public void deleteData(String key) {		
		repo.deleteData(key);
	}
	
	@CachePut(value = "rediscache", key = "'customkey'")
	public String updateData(String key, String val) {
		repo.updateData(key, val);
		return val;
	}
	
	@Cacheable(value = "rediscache", key = "'customkey'")
	public String selectData(String key) {	
		return repo.selectData(key);
	}
	
	@CacheEvict(value = "rediscache", key = "'customkey'")
	public void clearCache() {
		LOGGER.info("Cache cleared.");
	}
					
}

