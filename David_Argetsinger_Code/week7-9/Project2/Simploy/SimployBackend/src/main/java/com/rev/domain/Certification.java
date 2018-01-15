package com.rev.domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "CERTIFICATION")
public class Certification {

	@Id
	@Column(name = "certId")
	@SequenceGenerator(allocationSize = 1, name = "certSeq", sequenceName = "CERT_SEQ")
	@GeneratedValue(generator = "certSeq", strategy = GenerationType.SEQUENCE)
	private Integer certId;

	@Column(name = "title")
	private String title;
	@Column(name = "gotyear")
	private String gotYear;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resid")
	private Resume resume;

	public Certification() {
		super();
	}

	public Certification(String title, String gotYear, Resume resume) {
		super();
		this.title = title;
		this.gotYear = gotYear;
		this.resume = resume;
	}

	public Certification(Integer certId, String title, String gotYear, Resume resume) {
		super();
		this.certId = certId;
		this.title = title;
		this.gotYear = gotYear;
		this.resume = resume;
	}

	public Integer getCert_id() {
		return certId;
	}

	public void setCert_id(Integer certId) {
		this.certId = certId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGotYear() {
		return gotYear;
	}

	public void setGotYear(String gotYear) {
		this.gotYear = gotYear;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Certification [certId=" + certId + ", title=" + title + ", gotYear=" + gotYear + ", resume=" + resume
				+ "]";
	}

}
