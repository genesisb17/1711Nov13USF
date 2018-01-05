package com.rev.barberharbor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="BARBERS")
public class Barber extends User implements Serializable{

	private static final long serialVersionUID = 3561852746756800741L;
	
	@Id
	@Column(name="BARBERS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="BARBER_SEQ", sequenceName="BARBER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BARBER_SEQ")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SHOPS_ID")
	private Shop shop;
	
	@Column(name="WEBSITE")
	private String website;

	public Barber() {
		super();
	}

	public Barber(Shop shop, String website) {
		super();
		this.shop = shop;
		this.website = website;
	}

	public Barber(Long id, Shop shop, String website) {
		super();
		this.id = id;
		this.shop = shop;
		this.website = website;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	

}
