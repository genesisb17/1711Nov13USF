package com.rev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "JOB")
public class Job {

	@Id
	@Column(name = "jobId")
	@SequenceGenerator(allocationSize = 1, name = "jobSeq", sequenceName = "JOB_SEQ")
	@GeneratedValue(generator = "jobSeq", strategy = GenerationType.SEQUENCE)
	private Integer jobId;

	@Column(name = "description")
	private String description;

	@Column(name = "title")
	private String title;

	@Column(name = "location")
	private String location;

	@Column(name = "company")
	private String company;

	@Column(name = "website")
	private String website;

	@Column(name = "postdate")
	private String postDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "job_skills", joinColumns = { @JoinColumn(name = "jobId") }, inverseJoinColumns = {
			@JoinColumn(name = "skillId") })
	private List<Skill> skills=new ArrayList<>();

	public Job() {
		super();
	}

	public Job(String description, String title, String location, String company, String website, String postDate,
			User user, List<Skill> skills) {
		super();
		this.description = description;
		this.title = title;
		this.location = location;
		this.company = company;
		this.website = website;
		this.postDate = postDate;
		this.user = user;
		this.skills = skills;
	}

	public Job(Integer jobId, String description, String title, String location, String company, String website,
			String postDate, User user, List<Skill> skills) {
		super();
		this.jobId = jobId;
		this.description = description;
		this.title = title;
		this.location = location;
		this.company = company;
		this.website = website;
		this.postDate = postDate;
		this.user = user;
		this.skills = skills;
	}

	public Integer getjobId() {
		return jobId;
	}

	public void setjobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", description=" + description + ", title=" + title + ", location=" + location
				+ ", company=" + company + ", website=" + website + ", postDate=" + postDate + ", user=" + user
				+ ", skills=" + skills + "]";
	}

}
