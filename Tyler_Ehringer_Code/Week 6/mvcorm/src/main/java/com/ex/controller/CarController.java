package com.ex.controller;

import javax.jws.WebService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.model.Car;
import com.ex.service.CarService;

@RestController
public class CarController {
	
	static CarService cserv;
	static {
		cserv = new CarService();
	}
	
	@RequestMapping(value="/car/{licensePlate}", method=RequestMethod.GET)
	public Car getCar(@PathVariable String licensePlate) {
		return cserv.getByLicensePlate(licensePlate);
	}
	
	@RequestMapping(value="/car", method=RequestMethod.POST)
	public void addCar(@RequestBody Car c) {
		cserv.addCar(c);
	}

}
