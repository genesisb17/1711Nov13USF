package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ex.beans.Transcript;


@Entity
@Table(name="STUDENTS")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="student")
public class Student {
	
	@Id
	@Column(name="STUDENT_ID")
	@SequenceGenerator(name = "STUDENT_ID_SEQ", sequenceName="STUDENT_ID_SEQ")
	@GeneratedValue(generator="STUDENT_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="STUDENT_FNAME", nullable=false)	
	private String fName;
	@Column(name="STUDENT_LNAME", nullable=false)
	private String lName;
	@Column(name="STUDENT_EMAIL", nullable=false, unique=true)
	private String email;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRANSCRIPT_ID")
	private Transcript transcript;
	
	public Student() {	}

	public Student(String fName, String lName, String email) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	
	public Student(int id, String fName, String lName, String email) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}
	
	
	public Student(int id, String fName, String lName, String email, Transcript transcript) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.transcript = transcript;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", transcript="
				+ transcript + "]";
	}

	

}
