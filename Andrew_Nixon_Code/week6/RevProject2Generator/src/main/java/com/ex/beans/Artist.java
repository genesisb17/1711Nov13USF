package com.ex.beans;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Artist {
	
	private int barberId;
	private Set<Shop> serviceLocations;
	private int userId;

}
