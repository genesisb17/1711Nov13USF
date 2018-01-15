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
@Table(name="EXPERIENCE")
public class Experience {

	@Id
	@Column(name="expId")
	@SequenceGenerator(allocationSize = 1, name = "expSeq", sequenceName = "EXP_SEQ")
	@GeneratedValue(generator = "expSeq", strategy = GenerationType.SEQUENCE)
	private Integer expId;
	
	@Column(name="company")
	private String company;
	
	@Column(name="title")
	private String title;
	
	@Column(name="startYear")
	private String startYear;
	
	@Column(name="endYear")
	private String endYear;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resid")
    private Resume resume;

	public Experience() {
		super();
	}

	public Experience(String company, String title, String startYear, String endYear, Resume resume) {
		super();
		this.company = company;
		this.title = title;
		this.startYear = startYear;
		this.endYear = endYear;
		this.resume = resume;
	}

	public Experience(Integer expId, String company, String title, String startYear, String endYear, Resume resume) {
		super();
		this.expId = expId;
		this.company = company;
		this.title = title;
		this.startYear = startYear;
		this.endYear = endYear;
		this.resume = resume;
	}

	public Integer getexpId() {
		return expId;
	}

	public void setexpId(Integer expId) {
		this.expId = expId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Experience [expId=" + expId + ", company=" + company + ", title=" + title + ", startYear=" + startYear
				+ ", endYear=" + endYear + ", resume=" + resume + "]";
	}
	
	
}
