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

@Entity
@Table(name = "HIP_STUDENTS")
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@SequenceGenerator(name = "STUDENT_ID_SEQ", sequenceName = "STUDENT_ID_SEQ")
	@GeneratedValue(generator = "STUDENT_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String fname;

	@Column(name = "LAST_NAME", nullable = false)
	private String lname;

	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TRANSCRIPT_ID")
	private Transcript transcript;

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", transcript="
				+ transcript + "]";
	}

	public Student() {
		super();
	}

	public Student(String fname, String lname, String email, Transcript transcript) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.transcript = transcript;
	}

	public Student(int id, String fname, String lname, String email, Transcript transcript) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.transcript = transcript;
	}

	public Student(String fname, String lname, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
