package com.ex.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Driver")
public class Driver {
	
	@Id
	@Column
	@SequenceGenerator(allocationSize=1,name="driverSeq",sequenceName="D_SEQ")
	@GeneratedValue(generator="driverSeq",strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String fname;
	
	@Column
	private String lname;
	
	@OneToMany(mappedBy="driver", cascade=CascadeType.ALL)
	private Set<Car> cars;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
//
//	public Driver(Long id, String fname, String lname, Set<Car> cars) {
//		super();
//		this.id = id;
//		this.fname = fname;
//		this.lname = lname;
//		this.cars = cars;
//	}
//
//	public Driver(String fname, String lname, Set<Car> cars) {
//		super();
//		this.fname = fname;
//		this.lname = lname;
//		this.cars = cars;
//	}
//
//	public Driver() {
//		super();
//	}
//	
	

}
