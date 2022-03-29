package com.erwin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseService {

	@Autowired
	private DataSourceUat dataSourceUat;
	
	@Autowired
	private DataSourceDev dataSourceDev;
	
	@GetMapping(path="/db-dev")
	public DBDetails getDBDevDetails() {
		
		return new DBDetails(dataSourceDev.getDriverClass(), dataSourceDev.getUrl(),dataSourceDev.getUserName(),dataSourceDev.getPassword());
	}
	@GetMapping(path="/db-uat")
	public DBDetails getDBUatDetails() {
		
		return new DBDetails(dataSourceUat.getDriverClass(), dataSourceUat.getUrl(),dataSourceUat.getUserName(),dataSourceUat.getPassword());
	}
	

}
