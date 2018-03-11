package com.springboot.model;

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
@Table(name="Relations")
public class Relations 
{

	@Id
	@Column(name="r_id")
	@SequenceGenerator(allocationSize=1,name="RSeq",sequenceName="R_SEQ")
	@GeneratedValue(generator="RSeq",strategy=GenerationType.SEQUENCE)
	private Integer id;

	
	@Column(name="u_id1")
	private Integer u_id1;
	
	@Column(name="u_id2")
	private Integer u_id2;
	

	@Column(name="Wt")
	private Double Wt;
	
	@Column(name="w")
	private Double w;
	
	@Column(name="IHMHt")
	private Double IHM;
	
	@Column(name="rw")
	private Double rw;
}
