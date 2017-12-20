package com.ex.beans;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Barber {
	
	private int barberId;
	private Set<ServiceLocation> serviceLocations;
	private int userId;

}
