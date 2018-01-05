package com.rev.barberharbor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="SERVICE_TYPES")
public class ServiceType implements Serializable {

	private static final long serialVersionUID = -66788609024299130L;

	@Id
	@Column(name="SERVICE_TYPES_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="S_T_SEQ", sequenceName="S_T_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_T_SEQ")
	private Long id;
	
	@Column(name="TYPE")
	private String type;

	public ServiceType() {
		super();
	}

	public ServiceType(String type) {
		super();
		this.type = type;
	}

	public ServiceType(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
