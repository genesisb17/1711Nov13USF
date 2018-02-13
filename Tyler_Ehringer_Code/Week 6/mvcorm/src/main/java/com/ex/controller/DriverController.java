package com.ex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.model.Driver;
import com.ex.service.DriverService;

@RestController
public class DriverController {
	
	static DriverService dserv;
	static {
		dserv = new DriverService();
	}
	
	@RequestMapping(value = "/driver/{id}", method=RequestMethod.GET)
	public Driver getDriver(@PathVariable Long id) {
		return dserv.getDriverById(id);
	}
	
	@RequestMapping(value="/driver", method = RequestMethod.GET)
	public List<Driver> getDrivers(){
		return dserv.getAllDrivers();
	}
	
	@RequestMapping(value="/driver", method = RequestMethod.POST)
	public void addDriver(@RequestBody Driver d) {
		dserv.addDriver(d);
	}
	

}
