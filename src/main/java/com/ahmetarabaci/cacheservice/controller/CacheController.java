package com.ahmetarabaci.cacheservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ahmetarabaci.cacheservice.service.CacheInspectService;
import com.ahmetarabaci.cacheservice.service.CacheService;

@RestController
public class CacheController {

	@Autowired
	private CacheService service;
	@Autowired
	private CacheInspectService cacheInspectService;
	
	@PostMapping("/insertdata/{key}/{val}")
	public String insertData(@PathVariable("key") String key, @PathVariable("val") String val) {
		service.insertData(key, val); 
		return String.format("INSERT QUERY EXECUTED. -> KEY: %s - VAL: %s", key, val);
	}
	
	@PostMapping("/updatedata/{key}/{val}")
	public String updateData(@PathVariable("key") String key, @PathVariable("val") String val) {
		service.updateData(key, val);
		return String.format("UPDATE QUERY EXECUTED. -> KEY: %s - VAL: %s", key, val);
	}
	
	@PostMapping("/deletedata/{key}")
	public String deleteData(@PathVariable("key") String key) {
		service.deleteData(key);
		return String.format("DELETE QUERY EXECUTED. -> KEY: %s", key);
	}
	
	@GetMapping("/selectdata/{key}")
	public String selectData(@PathVariable("key") String key) {
		String val = service.selectData(key);
		return String.format("SELECT QUERY EXECUTED. -> KEY: %s - VAL: %s", key, val);
	}
	
	@GetMapping("/clearcache")
	public String clearCache() {
		service.clearCache();
		return "CACHE HAS BEEN CLEARED.";
	}
	
	@GetMapping("/getcacheinfo")
	public String getCacheInfo() {
		return cacheInspectService.printCacheContents("rediscache");
	}
}
