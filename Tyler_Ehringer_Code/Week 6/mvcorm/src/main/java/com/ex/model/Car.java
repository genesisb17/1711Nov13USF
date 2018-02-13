package com.ex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Car")
public class Car {
	
	@Id
	@Column
	@SequenceGenerator(allocationSize=1,name="carSeq",sequenceName="C_SEQ")
	@GeneratedValue(generator="carSeq",strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String make;
	
	@Column
	private String model;
	
	@Column
	private String color;
	
	@Column
	private String year;

	@Column
	private String licensePlate;

	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Car(Long id, String make, String model, String color, String year, String licensePlate, Driver driver) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.licensePlate = licensePlate;
		this.driver = driver;
	}

	public Car(String make, String model, String color, String year, String licensePlate, Driver driver) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.licensePlate = licensePlate;
		this.driver = driver;
	}

	public Car() {
		super();
	}
	
	
	

}
