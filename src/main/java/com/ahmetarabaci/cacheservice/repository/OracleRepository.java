package com.ahmetarabaci.cacheservice.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OracleRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(OracleRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertData(String key, String val) {
		try {
			int cnt = jdbcTemplate.update("INSERT INTO AHMETARABACI.CACHETEST (KEY, VAL) VALUES (?,?)", key, val);
			LOGGER.info(String.format("'%s'-'%s' data inserted into DB. | Insert cnt #: %s", key, val, cnt));
			return cnt;
		} catch (Exception e) {
			LOGGER.error("Exception occurred while inserting data into DB!", e);
			return 0;
		}
	}
	
	public int updateData(String key, String val) {
		try {
			int cnt = jdbcTemplate.update("UPDATE AHMETARABACI.CACHETEST SET VAL = ? WHERE KEY = ?", val, key);
			LOGGER.info(String.format("'%s'-'%s' data updated in DB. | Update cnt #: %s", key, val, cnt));
			return cnt;
		} catch (Exception e) {
			LOGGER.error("Exception occurred while updating data in DB!", e);
			return 0;
		}
	}
	
	public int deleteData(String key) {
		try {
			int cnt = jdbcTemplate.update("DELETE FROM AHMETARABACI.CACHETEST WHERE KEY = ?", key);
			LOGGER.info(String.format("'%s' data deleted from DB. | Delete cnt #: %s", key, cnt));
			return cnt;
		} catch (Exception e) {
			LOGGER.error("Exception occurred while deleting data from DB!", e);
			return 0;
		}
	}
	
	public String selectData(String key) {
		try {
			String data = jdbcTemplate.queryForObject("SELECT VAL FROM AHMETARABACI.CACHETEST WHERE KEY = ?", String.class, key);
			LOGGER.info(String.format("'%s' data selected from DB for '%s' key.", data, key));
			return data;
		} catch (Exception e) {
			LOGGER.error("Exception occurred while selecting data from DB!", e);
			return "NOK";
		}
		
	}
	
}
