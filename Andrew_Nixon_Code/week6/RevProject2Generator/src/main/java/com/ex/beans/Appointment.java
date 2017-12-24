package com.ex.beans;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PH_APPOINTMENTS")
public class Appointment {
	
	@Id
	@Column(name="APPNTMNT_ID")
	@SequenceGenerator(name="A_SEQ", sequenceName="A_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="A_SEQ")
	private int appointmentId;
	
	@Column(name="APPNTMNT_DATE", nullable = false)
	private Date date;
	
	@Column(name="APPNTMNT_START", nullable = false)
	private Time startTime;
	
	@Column(name="APPNTMNT_END", nullable = false)
	private Time endTime;
	
	private int serviceId;
	private int clientId;
	

}
