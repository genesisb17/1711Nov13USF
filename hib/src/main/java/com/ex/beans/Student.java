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

@Entity
@Table(name="STUDENTS")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="student")
public class Student 
{
	@Id
	@Column(name="STUDENT_ID")
	@SequenceGenerator(name = "STUDENT_ID_SEQ",sequenceName="STUDENT_ID_SEQ")
	@GeneratedValue(generator="STUDENT_ID_SEQ",strategy=GenerationType.SEQUENCE)
	private int id;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable=false)
	private String firstname;
	@Column(nullable=false)
	private String lastname;
	@Column(nullable=false,unique = true)
	private String email;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TRANSCRIPT_ID")
	private Transcript Transcript;

	/**
	 * @return the transcript
	 */
	public Transcript getTranscript() {
		return Transcript;
	}

	/**
	 * @param transcript the transcript to set
	 */
	public void setTranscript(Transcript transcript) {
		Transcript = transcript;
	}
	
	public Student(int id, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	
	public Student(String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	public Student()
	{
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", Transcript=" + Transcript + "]";
	}


}