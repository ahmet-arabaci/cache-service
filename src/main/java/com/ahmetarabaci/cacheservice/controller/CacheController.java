package com.ahmetarabaci.cacheservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ahmetarabaci.cacheservice.service.CacheInspectService;
import com.ahmetarabaci.cacheservice.service.CacheService;

@RestController
public class CacheController {

	@Autowired
	private CacheService service;
	@Autowired
	private CacheInspectService inspectService;
	
	@GetMapping("/getdata")
	public String getData() {
		return service.getData();		
	}
	
	@GetMapping("/getcache")
	public String getCache() {
		return service.getCache();
	}
	
	@PostMapping("/updatedata")
	public String updateData(@RequestBody String data) {
		service.updateData(data);
		return String.format("Only VAR has been updated with: '%s'", data);
	}
	
	@PostMapping("/updatecache")
	public String updateCache(@RequestBody String data) {
		service.updateCache(data);
		return String.format("VAR and cache has been updated with: '%s'", data);
	}
	
	@GetMapping("/clearcache")
	public String clearCache() {
		return service.clearCache();
	}
	
	@GetMapping("/getcachecontents")
	public String getCacheContents() {
		return inspectService.getCacheContents("rediscache");
	}
}
